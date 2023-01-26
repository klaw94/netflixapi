package com.example.netflixdatabaseapi.dao;
import com.example.netflixdatabaseapi.model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieDao {

    int insertMovie(Integer employeeId, Movie movie);


    List<Movie> selectAllMovies();

    int deleteMovieById(int id, Integer employeeId);

    int updateMovieById(int id, Movie movie);

}