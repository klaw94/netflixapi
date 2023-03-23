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
import java.util.Optional;

@Repository("postgres")
public class MediaDataAccessService implements MediaDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertMovie(Integer id, String mediaType, String backdropPath) {
        String sql = "INSERT INTO media (id, media_type, backdrop_path) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, mediaType, backdropPath);
        return 0;
    }

    @Override
    public Optional<Media> getMediaByIdAndMediaType(Integer id, String mediaType) {
        String sql = "SELECT * FROM media WHERE id = ? AND media_type = ? ; ";
        List<Media> mediaList = jdbcTemplate.query(sql, new Object[]{id, mediaType}, (resultSet, i) -> {
                String backdrop_path = resultSet.getString("backdrop_path");

                return new Media(id, mediaType, backdrop_path);
        });
        return mediaList.size() == 0 ? Optional.empty() : Optional.of(mediaList.get(0));
    }


    @Override
    public List<Media> getMediaInMyList(Integer employeeId) {
        String sql = "SELECT * FROM media JOIN watchlist ON watchlist.media_id = media.id " +
                "AND watchlist.media_type = media.media_type" +
                " WHERE watchlist.user_id = ?  ";

        return jdbcTemplate.query(sql, new Object[]{employeeId}, (resultSet, i) -> {
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String media_type = resultSet.getString("media_type");
            String backdrop_path = resultSet.getString("backdrop_path");
            return new Media(id, media_type, backdrop_path);
        });
    }

    @Override
    public int deleteMediaById(int mediaId, String mediaType) {

        String sql = "DELETE FROM media WHERE id = ? AND media_type = ?";
        jdbcTemplate.update(sql, mediaId, mediaType);

        return 0;
    }


}
