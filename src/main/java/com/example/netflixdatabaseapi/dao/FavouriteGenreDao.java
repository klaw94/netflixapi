package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.Genre;
import com.example.netflixdatabaseapi.responsemodels.FavouriteGenreResponseModel;

import java.util.List;

public interface FavouriteGenreDao {

    int insertFavouriteGenre(Integer employeeId, Genre favouriteGenres);

    List<FavouriteGenreResponseModel> selectAllFavouriteGenres();

    int deleteFavouriteGenre(Integer genreId, Integer employeeId);

    //Do I need score here??
    int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition);
}
