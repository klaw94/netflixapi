package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("liked")
public class LikeDataAccessService implements LikeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LikeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLikedMovie(Integer employeeId, LikedMoviesResponseModel likedMovie) {
        String sql = "INSERT INTO liked_films (employeeid, id, media_type, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 0, likedMovie.getId(), likedMovie.getMediaType(), likedMovie.getStatus());

        return 0;

    }


    @Override
    public List<LikedMoviesResponseModel> selectAllLikes() {
        final String sql = "SELECT * FROM liked_films";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer employeeId = Integer.valueOf(resultSet.getString("employeeid"));
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String status = resultSet.getString("status");
            return new LikedMoviesResponseModel(id, employeeId, media_type, status);
        });

    }

    @Override
    public List<Like> selectAllLikesByUserId(Integer userId) {
        final String sql = "SELECT * FROM likes where user_id = ? ;";
        return jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, i) -> {
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String like_type = resultSet.getString("like_type");
            return new Like(id, userId, like_type, media_type);
        });
    }

    @Override
    public int deleteLikedMovieById(int id, Integer employeeId) {

        String sql = "DELETE FROM liked_films WHERE id = ? AND employeeid = ?";
        //Specifying the values of it's parameter
        jdbcTemplate.update(sql, id, employeeId);

        return 0;
    }

    @Override
    public int updateLikedMovieById(int id, LikedMoviesResponseModel likedMovie) {
//        String sql = "UPDATE liked_films " +
//                "SET status = ? " +
//                "WHERE id = ?;";
//        jdbcTemplate.update(sql, 0, likedMovie.getStatus(), likedMovie.getId());

        return 0;

    }

}
