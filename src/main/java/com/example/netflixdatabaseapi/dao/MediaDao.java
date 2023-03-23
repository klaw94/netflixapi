package com.example.netflixdatabaseapi.dao;
import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;

import java.util.List;
import java.util.Optional;

public interface MediaDao {

    int insertMovie(Integer id, String mediaType, String backdropPath);


    Optional<Media> getMediaByIdAndMediaType(Integer id, String mediaType);

    int deleteMediaById(int id, String mediaType);

    List<Media> getMediaInMyList(Integer employeeId);

}