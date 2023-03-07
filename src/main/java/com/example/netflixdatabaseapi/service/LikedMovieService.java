package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.LikedMovieDao;
import com.example.netflixdatabaseapi.model.LikedMovie;
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

    public int addLikedMovie(Integer employeeID, LikedMovie likedMovie){
        return likedMovieDao.insertLikedMovie(employeeID, likedMovie);
    }

    public List<LikedMovie> getAllLikedMovies(){
        return likedMovieDao.selectAllLikedMovies();
    }

    public int deleteLikedMovie(Integer id, Integer employeeId){
        return likedMovieDao.deleteLikedMovieById(id, employeeId);
    }

    public int updateLikedMovie(Integer employeeId, LikedMovie newLikedMovie){
        return likedMovieDao.updateLikedMovieById(employeeId, newLikedMovie);
    }
}
