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
public class MovieDataAccessService implements MovieDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMovie(Integer employeeId, Movie movie) {
        //final String sql = "INSERT INTO mylist (employeeID, id, media_type, backdrop_path) VALUES (0, ?, ?, ?)";
        try {
            //Creating Connection Object
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
            //Preapared Statement
            PreparedStatement ps =connection.prepareStatement("INSERT INTO mylist (employeeid, id, media_type, backdrop_path) VALUES (?, ?, ?, ?)");
            //Specifying the values of it's parameter
            ps.setInt(1, 0);
            ps.setInt(2, movie.getId());
            ps.setString(3, movie.getMediaType());
            ps.setString(4, movie.getBackdrop_path());
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

        try {
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM mylist WHERE id = ? AND employeeid = ?");
            //Specifying the values of it's parameter
            ps.setInt(1, id);
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
    public int updateMovieById(int id, Movie movie) {
        return 0;
    }

//    @Override
//    public Optional<Movie> selectPersonById(UUID id) {
//        final String sql = "SELECT id, name FROM person WHERE id =?";
//        Person person = jdbcTemplate.queryForObject(
//                sql,
//                new Object[]{id}, (resultSet, i) -> {
//                    UUID personId = UUID.fromString(resultSet.getString("id"));
//                    String name = resultSet.getString("name");
//                    return new Person(personId, name);
//                });
//
//        return Optional.ofNullable(person);
//
//        //return Optional.empty();
//    }
}
