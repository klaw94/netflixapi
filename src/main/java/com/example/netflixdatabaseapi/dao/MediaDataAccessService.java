package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres")
public class MediaDataAccessService implements MediaDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @param employeeId
     * @param media
     * @return 0 is success and 404 is error
     */
    @Override
    public int insertMovie(Integer employeeId, Media media) {
        //final String sql = "INSERT INTO mylist (employeeID, id, media_type, backdrop_path) VALUES (0, ?, ?, ?)";
        try {
            //Creating Connection Object
            Connection connection= DriverManager.getConnection("jdbc:postgresql:////localhost:5432/postgres","postgres","password");
            //Preapared Statement
            PreparedStatement ps =connection.prepareStatement("INSERT INTO mylist (employeeid, id, media_type, backdrop_path) " +
                    "VALUES (?, ?, ?, ?); ");
            //Specifying the values of it's parameter
            ps.setInt(1, 0);
            ps.setInt(2, media.getId());
            ps.setString(3, media.getMediaType());
            ps.setString(4, media.getBackdrop_path());
            //Execute the query
            ps.executeUpdate();
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
    }


    @Override
    public List<WatchListMovieResponseModel> selectAllMovies() {
        final String sql = "SELECT * FROM mylist";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer employeeId = Integer.valueOf(resultSet.getString("employeeid"));
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String backdrop_path = resultSet.getString("backdrop_path");
            return new WatchListMovieResponseModel(id, employeeId, media_type, backdrop_path);
        });

    }

    @Override
    public List<Media> getMoviesInMyList(Integer employeeId){
        try {
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            //Preapared Statement
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM media JOIN watchlist ON watchlist.media_id = media.id " +
                            "AND watchlist.media_type = media.media_type" +
                            " WHERE watchlist.user_id = ?  ");
            //Specifying the values of it's parameter
            ps.setInt(1, employeeId);

            //Execute the query
            String sql = ps.toString();
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String media_type = resultSet.getString("media_type");
                String backdrop_path = resultSet.getString("backdrop_path");
                return new Media(id, media_type, backdrop_path);
            });

        } catch (SQLException e1) {
            e1.printStackTrace();
            List<Media> list = new ArrayList<>();
            return list;
        }
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
            return 0;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return 404;
        }
    }

    @Override
    public int updateMovieById(int id, Media media) {
        return 0;
    }

}
