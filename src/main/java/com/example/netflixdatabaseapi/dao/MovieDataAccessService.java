package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("postgres")
public class MovieDataAccessService implements MovieDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMovie(Integer employeeId, Movie movie) {
        String sql = "INSERT INTO mylist (employeeid, id, media_type, backdrop_path) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 0, movie.getId(), movie.getMediaType(), movie.getBackdrop_path());
        return 0;
    }


    @Override
    public List<Movie> selectAllMovies() {
        final String sql = "SELECT * FROM mylist";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer employeeId = Integer.valueOf(resultSet.getString("employeeid"));
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String backdrop_path = resultSet.getString("backdrop_path");
            return new Movie(id, employeeId, media_type, backdrop_path);
        });

    }

    @Override
    public int deleteMovieById(int id, Integer employeeId) {

        String sql = "DELETE FROM mylist WHERE id = ? AND employeeid = ?";
        jdbcTemplate.update(sql, id, employeeId);

        return 0;
    }

    @Override
    public int updateMovieById(int id, Movie movie) {
        return 0;
    }

}
