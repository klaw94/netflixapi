package com.example.netflixdatabaseapi.dao;

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
    public int insertFavouriteGenre(Integer employeeId, FavouriteGenreResponseModel favouriteGenres) {
        try {
            //Creating Connection Object
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO favourite_genres " +
                            "(employeeid, genre_id, score, genre_name) " +
                            "VALUES (?, ?, ?, ?)");
            //Specifying the values of it's parameter
            ps.setInt(1, 0);
            ps.setInt(2, favouriteGenres.getGenreId());
            ps.setInt(3, favouriteGenres.getScore());
            ps.setString(4, favouriteGenres.getGenreName());
            //Execute the query
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
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

        try {
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM favourite_genres WHERE genre_id = ? AND employeeid = ?");
            //Specifying the values of it's parameter
            ps.setInt(1, genreId);
            ps.setInt(2, employeeId);

            //Execute the query
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
    }

    @Override
    public int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition) {
        try {
            //TODO refactor this into its own getbyID method
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT score FROM favourite_genres " +
                            "WHERE genre_id = ? AND employeeid = ?;");
            //Specifying the values of it's parameter
            ps.setInt(1, genreId);
            ps.setInt(2, employeeId);

            String sql = ps.toString();

           Integer score = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
                return Integer.valueOf(resultSet.getString("score"));
            });
            score = score + addition;

            //Specifying the values of it's parameter
            //Preapared Statement
             ps = connection.prepareStatement(
                    "UPDATE favourite_genres " +
                            "SET score = ? " +
                            "WHERE genre_id = ? AND employeeid = ?;");

            //Specifying the values of it's parameter
            ps.setInt(1, score);
            ps.setInt(2, genreId);
            ps.setInt(3, employeeId);


            //Execute the query
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
    }
}
