package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Genre;
import com.example.netflixdatabaseapi.responsemodels.FavouriteGenreResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("favourite")
public class FavouriteGenreDataAccessService implements FavouriteGenreDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FavouriteGenreDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertFavouriteGenre(Integer employeeId, Genre favouriteGenres) {
//        String sql = "INSERT INTO favourite_genres " +
//                "(employeeid, genre_id, score, genre_name) " +
//                "VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sql, 0, Genre.getGenreId(), Genre.getScore(), Genre.getGenreName());
        return 0;

    }


    @Override
    public List<FavouriteGenreResponseModel> selectAllFavouriteGenres() {
        final String sql = "SELECT * FROM favourite_genres ORDER BY score DESC";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer employeeId = Integer.valueOf(resultSet.getString("employeeid"));
            Integer genre_id = Integer.valueOf(resultSet.getString("genre_id"));
            Integer score = Integer.valueOf(resultSet.getString("score"));
            String genreName = resultSet.getString("genre_name");
            return new FavouriteGenreResponseModel(genre_id, employeeId, score, genreName);
        });

    }

    @Override
    public int deleteFavouriteGenre(Integer genreId, Integer employeeId) {
        String sql = "DELETE FROM favourite_genres WHERE genre_id = ? AND employeeid = ?";
        jdbcTemplate.update(sql, genreId, employeeId);
        return 0;


    }

    @Override
    public int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition) {
        //This is not here anymore of couse. This needs to go to the
        String sql = "SELECT score FROM favourite_genres " +
                "WHERE genre_id = ? AND employeeid = ?;";

        Integer score = jdbcTemplate.queryForObject(sql, new Object[]{genreId, employeeId}, (resultSet, i) -> {
            return Integer.valueOf(resultSet.getString("score"));
        });
        score = score + addition;

        //Specifying the values of it's parameter
        //Preapared Statement
        sql = "UPDATE favourite_genres " +
                "SET score = ? " +
                "WHERE genre_id = ? AND employeeid = ?;";
        jdbcTemplate.update(sql, score, genreId, employeeId);

        return 0;

    }
}
