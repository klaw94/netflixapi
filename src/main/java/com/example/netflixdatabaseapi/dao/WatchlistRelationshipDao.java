package com.example.netflixdatabaseapi.dao;

public interface WatchlistRelationshipDao {

    int insertWatchlistRelationship(Integer userId, Integer mediaId, String mediaType);

}
