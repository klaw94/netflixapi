package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.FavouriteGenresDao;
import com.example.netflixdatabaseapi.dao.FavouriteGenresDao;
import com.example.netflixdatabaseapi.model.FavouriteGenres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteGenresService {

    private final FavouriteGenresDao favouriteGenresDao;

    @Autowired
    public FavouriteGenresService(@Qualifier("favourite") FavouriteGenresDao favouriteGenresDao){
        this.favouriteGenresDao = favouriteGenresDao;
    }

    public int addFavouriteGenres(Integer employeeID, FavouriteGenres favouriteGenres){
        return favouriteGenresDao.insertFavouriteGenre(employeeID, favouriteGenres);
    }

    public List<FavouriteGenres> getAllFavouriteGenress(){
        return favouriteGenresDao.selectAllFavouriteGenres();
    }

    public int deleteFavouriteGenres(Integer id, Integer employeeId){
        return favouriteGenresDao.deleteFavouriteGenre(id, employeeId);
    }

    public int updateScoreFavouriteGenre(Integer genreId, Integer employeeId, Integer addition){
        return favouriteGenresDao.updateScoreFavouriteGenre(genreId, employeeId, addition);
    }
}
