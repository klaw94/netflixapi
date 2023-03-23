package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.WatchlistRelationship;

import java.util.Optional;

public interface WatchlistRelationshipDao {

    int insertWatchlistRelationship(Integer userId, Integer mediaId, String mediaType);

    int deleteWatchlistRelationship( Integer mediaId, Integer userId, String mediaType);

    Optional<WatchlistRelationship> getWatchlistRelationshipById(Integer mediaId, String mediaType);
}
