package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.model.WatchlistRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("watchlist")
public class WatchlistRelationshipDataAccessService implements WatchlistRelationshipDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WatchlistRelationshipDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertWatchlistRelationship(Integer userId, Integer mediaId, String mediaType){
        String sql = "INSERT INTO watchlist (user_id, media_id, media_type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, userId, mediaId, mediaType);
        return 0;    }

    @Override
    public int deleteWatchlistRelationship(Integer mediaId, Integer userId, String mediaType) {
        String sql = "DELETE FROM watchlist WHERE user_id = ? AND media_id = ? AND media_type = ? ";
        jdbcTemplate.update(sql, userId, mediaId, mediaType);

        return 0;
    }

    @Override
    public Optional<WatchlistRelationship> getWatchlistRelationshipById(Integer mediaId, String mediaType) {
        String sql = "SELECT * FROM watchlist WHERE media_id = ? AND media_type = ? ; ";
        List<WatchlistRelationship> watchlistRelationshipList = jdbcTemplate.query(sql, new Object[]{mediaId, mediaType}, (resultSet, i) -> {
            Integer userId = Integer.valueOf(resultSet.getString("user_id"));

            return new WatchlistRelationship(userId, mediaId, mediaType);
        });
        return watchlistRelationshipList.size() == 0 ? Optional.empty() : Optional.of(watchlistRelationshipList.get(0));
    }


}
