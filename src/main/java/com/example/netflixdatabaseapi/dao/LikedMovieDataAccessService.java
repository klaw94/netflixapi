package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.LikedMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Repository("liked")
public class LikedMovieDataAccessService implements LikedMovieDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LikedMovieDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLikedMovie(Integer employeeId, LikedMovie likedMovie) {
        //final String sql = "INSERT INTO mylist (employeeID, id, media_type, backdrop_path) VALUES (0, ?, ?, ?)";
        try {
            //Creating Connection Object
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
            //Preapared Statement
            PreparedStatement ps =connection.prepareStatement("INSERT INTO liked_films (employeeid, id, media_type, status) VALUES (?, ?, ?, ?)");
            //Specifying the values of it's parameter
            ps.setInt(1, 0);
            ps.setInt(2, likedMovie.getId());
            ps.setString(3, likedMovie.getMediaType());
            ps.setString(4, likedMovie.getStatus());
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
    public List<LikedMovie> selectAllLikedMovies() {
        final String sql = "SELECT * FROM liked_films";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer employeeId = Integer.valueOf(resultSet.getString("employeeid"));
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String status = resultSet.getString("status");
            return new LikedMovie(id, employeeId, media_type, status);
        });

    }

    @Override
    public int deleteLikedMovieById(int id, Integer employeeId) {

        try {
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM liked_films WHERE id = ? AND employeeid = ?");
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
    public int updateLikedMovieById(int id, LikedMovie likedMovie) {
        try {
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE liked_films " +
                            "SET status = ? " +
                            "WHERE id = ?;");

            //Specifying the values of it's parameter
            ps.setString(1, likedMovie.getStatus());
            ps.setInt(2, likedMovie.getId());


            //Execute the query
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
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
