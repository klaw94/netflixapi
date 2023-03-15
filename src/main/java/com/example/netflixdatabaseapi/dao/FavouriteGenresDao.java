package com.example.netflixdatabaseapi.dao;

import com.example.netflixdatabaseapi.model.FavouriteGenres;
import com.example.netflixdatabaseapi.model.LikedMovie;

import java.util.List;

public interface FavouriteGenresDao {

    int insertFavouriteGenre(Integer employeeId, FavouriteGenres favouriteGenres);

    List<FavouriteGenres> selectAllFavouriteGenres();

    int deleteFavouriteGenre(Integer genreId, Integer employeeId);

    //Do I need score here??
    int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition);
}
