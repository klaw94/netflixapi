package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.responsemodels.LikedMoviesRequestModel;

import java.util.List;

public interface LikedMovieDao {
    int insertLikedMovie(Integer employeeId, LikedMoviesRequestModel likedMovie);


    List<LikedMoviesRequestModel> selectAllLikedMovies();

    int deleteLikedMovieById(int id, Integer employeeId);

    int updateLikedMovieById(int id,  LikedMoviesRequestModel likedMovie);
}
