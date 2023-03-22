package com.example.netflixdatabaseapi.api;


import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;
import com.example.netflixdatabaseapi.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RequestMapping("api/v1/movie")
@RestController
public class ListController {

    private final ListService listService;

    @Autowired
    public ListController(ListService listService){
        this.listService = listService;
    }

    @CrossOrigin
    @PostMapping
    public void addMovieToList(Integer employeeId, @Valid @NonNull @RequestBody Media media){
        listService.addMovie(employeeId, media);
    }
    @CrossOrigin
    @GetMapping
    public List<WatchListMovieResponseModel> getAllMovies() {
        return listService.getAllMovies();
    }

    @GetMapping(path = "{userId}")
    public List<WatchListMovieResponseModel> getMoviesInMyList(@PathVariable("userId") Integer userId){
        return listService.getMoviesInMyList(userId);
    }

    @CrossOrigin
    @DeleteMapping(path = "{id}/{employeeId}")
    public void deleteMovieById(@PathVariable("id") int id, @PathVariable("employeeId") Integer employeeId){
        listService.deleteMovie(id, employeeId);
    }

    @PutMapping(path = "{id}")
    public void updateMovie(Integer employeeId, @PathVariable("id") int id, @Valid @NonNull @RequestBody Media media){
        listService.updateMovie(employeeId, media);
    }
}


