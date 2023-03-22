package com.example.netflixdatabaseapi.dao;
import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;

import java.util.List;

public interface MediaDao {

    int insertMovie(Integer employeeId, Media media);


    List<WatchListMovieResponseModel> selectAllMovies();

    int deleteMovieById(int id, Integer employeeId);

    int updateMovieById(int id, Media media);

    public List<Media> getMoviesInMyList(Integer employeeId);

}