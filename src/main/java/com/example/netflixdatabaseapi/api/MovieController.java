package com.example.netflixdatabaseapi.api;


import com.example.netflixdatabaseapi.model.Movie;
import com.example.netflixdatabaseapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/movie")
@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController (MovieService movieService){
        this.movieService = movieService;
    }

    @CrossOrigin
    @PostMapping
    public void addMovie(Integer employeeId, @Valid @NonNull @RequestBody Movie movie){
        movieService.addMovie(employeeId, movie);
    }
    @CrossOrigin
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

//    @GetMapping(path = "{id}")
//    public Person getPersonById(@PathVariable("id") UUID id){
//        return personService.getPersonById(id)
//                .orElse(null);
//    }

    @DeleteMapping(path = "{id}/{employeeId}")
    public void deleteMovieById(@PathVariable("id") int id, @PathVariable("employeeId") Integer employeeId){
        movieService.deleteMovie(id, employeeId);
    }

    @PutMapping(path = "{id}")
    public void updateMovie(Integer employeeId, @PathVariable("id") int id, @Valid @NonNull @RequestBody Movie movieToUpdate){
        movieService.updateMovie(employeeId, movieToUpdate);
    }
}


