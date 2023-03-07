package com.example.netflixdatabaseapi.api;

import com.example.netflixdatabaseapi.model.LikedMovie;
import com.example.netflixdatabaseapi.model.Movie;
import com.example.netflixdatabaseapi.service.LikedMovieService;
import com.example.netflixdatabaseapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/liked-movie")
@RestController
public class LikedMovieController {

    private final LikedMovieService likedMovieService;

    @Autowired
    public LikedMovieController ( LikedMovieService likedMovieService){
        this.likedMovieService = likedMovieService;
    }

    @CrossOrigin
    @PostMapping
    public void addLikedMovie(Integer employeeId, @Valid @NonNull @RequestBody LikedMovie likedMovie){
        likedMovieService.addLikedMovie(employeeId, likedMovie);
    }
    @CrossOrigin
    @GetMapping
    public List<LikedMovie> getAllLikedMovies() {
        return likedMovieService.getAllLikedMovies();
    }

//    @GetMapping(path = "{id}")
//    public Person getPersonById(@PathVariable("id") UUID id){
//        return personService.getPersonById(id)
//                .orElse(null);
//    }

    @CrossOrigin
    @DeleteMapping(path = "{id}/{employeeId}")
    public void deleteLikedMovieById(@PathVariable("id") int id, @PathVariable("employeeId") Integer employeeId){
        likedMovieService.deleteLikedMovie(id, employeeId);
    }

    @PutMapping(path = "{id}/{employeeId}")
    public void updateMovie(@PathVariable("id") int id, @Valid @NonNull @RequestBody LikedMovie likedMovieToUpdate,  @PathVariable("employeeId") Integer employeeId){
        likedMovieService.updateLikedMovie(employeeId, likedMovieToUpdate);
    }
}
