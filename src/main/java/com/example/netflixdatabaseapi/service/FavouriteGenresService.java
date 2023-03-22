package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.FavouriteGenreDao;
import com.example.netflixdatabaseapi.model.Genre;
import com.example.netflixdatabaseapi.responsemodels.FavouriteGenreResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteGenresService {

    private final FavouriteGenreDao favouriteGenreDao;

    @Autowired
    public FavouriteGenresService(@Qualifier("favourite") FavouriteGenreDao favouriteGenreDao){
        this.favouriteGenreDao = favouriteGenreDao;
    }

    public int addFavouriteGenres(Integer employeeID, Genre favouriteGenres){
        return favouriteGenreDao.insertFavouriteGenre(employeeID, favouriteGenres);
    }

    public List<FavouriteGenreResponseModel> getAllFavouriteGenres(){
        return favouriteGenreDao.selectAllFavouriteGenres();
    }

    public int deleteFavouriteGenres(Integer id, Integer employeeId){
        return favouriteGenreDao.deleteFavouriteGenre(id, employeeId);
    }

    public int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition){
        return favouriteGenreDao.updateScoreFavouriteGenre(genreId, employeeId, addition);
    }
}
