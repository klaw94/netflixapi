package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.LikedMovieDao;
import com.example.netflixdatabaseapi.responsemodels.LikedMoviesRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedMovieService {

    private final LikedMovieDao likedMovieDao;

    @Autowired
    public LikedMovieService(@Qualifier("liked") LikedMovieDao likedMovieDao){
        this.likedMovieDao = likedMovieDao;
    }

    public int addLikedMovie(Integer employeeID, LikedMoviesRequestModel likedMovie){
        return likedMovieDao.insertLikedMovie(employeeID, likedMovie);
    }

    public List<LikedMoviesRequestModel> getAllLikedMovies(){
        return likedMovieDao.selectAllLikedMovies();
    }

    public int deleteLikedMovie(Integer id, Integer employeeId){
        return likedMovieDao.deleteLikedMovieById(id, employeeId);
    }

    public int updateLikedMovie(Integer employeeId, LikedMoviesRequestModel newLikedMovie){
        return likedMovieDao.updateLikedMovieById(employeeId, newLikedMovie);
    }
}
