package com.example.netflixdatabaseapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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


}
