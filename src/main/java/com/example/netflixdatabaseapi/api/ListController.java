package com.example.netflixdatabaseapi.api;


import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.requestmodels.WatchlistMovieRequestModel;
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
    public void addMediaToList(@Valid @NonNull @RequestBody WatchlistMovieRequestModel watchlistMovieRequestModel){
        listService.addMovie(watchlistMovieRequestModel);
    }

    @GetMapping(path = "{userId}")
    public List<WatchListMovieResponseModel> getMoviesInMyList(@PathVariable("userId") Integer userId){
        return listService.getMediaInMyList(userId);
    }

    @CrossOrigin
    @DeleteMapping(path = "{id}/{employeeId}/{mediaType}")
    public void deleteMovieById(@PathVariable("id") int id, @PathVariable("employeeId") Integer employeeId, @PathVariable("mediaType") String mediaType){
        listService.deleteMovie(id, employeeId, mediaType);
    }


}


