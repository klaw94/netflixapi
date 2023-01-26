package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.MovieDao;
import com.example.netflixdatabaseapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieService(@Qualifier("postgres") MovieDao movieDao){
        this.movieDao = movieDao;
    }

    public int addMovie(Integer employeeID, Movie movie){
        return movieDao.insertMovie(employeeID, movie);
    }

    public List<Movie> getAllMovies(){
        return movieDao.selectAllMovies();
    }

    public int deleteMovie(Integer id, Integer employeeId){
        return movieDao.deleteMovieById(id, employeeId);
    }

    public int updateMovie(Integer employeeId, Movie newMovie){
        return movieDao.updateMovieById(employeeId, newMovie);
    }
}
