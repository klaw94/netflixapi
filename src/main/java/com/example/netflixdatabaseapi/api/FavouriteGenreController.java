package com.example.netflixdatabaseapi.api;

import com.example.netflixdatabaseapi.responsemodels.FavouriteGenreResponseModel;
import com.example.netflixdatabaseapi.service.FavouriteGenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/favourite-genres")
@RestController
public class FavouriteGenreController {

    private final FavouriteGenresService favouriteGenresService;

    @Autowired
    public FavouriteGenreController(FavouriteGenresService favouriteGenresService){
        this.favouriteGenresService = favouriteGenresService;
    }

    @CrossOrigin
    @PostMapping
    public void addFavouriteGenres(Integer employeeId, @Valid @NonNull @RequestBody FavouriteGenreResponseModel favouriteGenres){
        favouriteGenresService.addFavouriteGenres(employeeId, favouriteGenres);
    }

    @CrossOrigin
    @GetMapping
    public List<FavouriteGenreResponseModel> getAllFavouriteGenres() {
        return favouriteGenresService.getAllFavouriteGenress();
    }


    @CrossOrigin
    @DeleteMapping(path = "{genre_id}/{employeeId}")
    public void deleteFavouriteGenres(@PathVariable("genre_id") int genreId, @PathVariable("employeeId") Integer employeeId){
        favouriteGenresService.deleteFavouriteGenres(genreId, employeeId);
    }


    @CrossOrigin
    @PutMapping(path = "{genre_id}/{employeeId}/{addition}")
    public void updateScoreFavouriteGenre(@PathVariable("genre_id") int genreId,  @PathVariable("employeeId") Integer employeeId, @PathVariable("addition") Integer addition){
        favouriteGenresService.updateScoreFavouriteGenre(genreId, employeeId, addition);
    }
}
