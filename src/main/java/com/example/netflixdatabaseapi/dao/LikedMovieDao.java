package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.LikedMovie;

import java.util.List;

public interface LikedMovieDao {
    int insertLikedMovie(Integer employeeId, LikedMovie likedMovie);


    List<LikedMovie> selectAllLikedMovies();

    int deleteLikedMovieById(int id, Integer employeeId);

    int updateLikedMovieById(int id,  LikedMovie likedMovie);
}
