package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Like;

import java.util.List;

public interface LikeDao {
    int insertLikedMovie(Integer employeeId, LikedMoviesResponseModel likedMovie);


    List<LikedMoviesResponseModel> selectAllLikes();
    List<Like> selectAllLikesByUserId(Integer userId);

    int deleteLikedMovieById(int id, Integer employeeId);

    int updateLikedMovieById(int id,  LikedMoviesResponseModel likedMovie);
}
