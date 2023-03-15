package com.example.netflixdatabaseapi.api;

import com.example.netflixdatabaseapi.model.FavouriteGenres;
import com.example.netflixdatabaseapi.service.FavouriteGenresService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/favourite-genres")
@RestController
public class FavouriteGenresController {

    private final FavouriteGenresService favouriteGenresService;

    @Autowired
    public FavouriteGenresController ( FavouriteGenresService favouriteGenresService){
        this.favouriteGenresService = favouriteGenresService;
    }

    @CrossOrigin
    @PostMapping
    public void addFavouriteGenres(Integer employeeId, @Valid @NonNull @RequestBody FavouriteGenres favouriteGenres){
        favouriteGenresService.addFavouriteGenres(employeeId, favouriteGenres);
    }

    @CrossOrigin
    @GetMapping
    public List<FavouriteGenres> getAllFavouriteGenres() {
        return favouriteGenresService.getAllFavouriteGenress();
    }

//    @GetMapping(path = "{id}")
//    public Person getPersonById(@PathVariable("id") UUID id){
//        return personService.getPersonById(id)
//                .orElse(null);
//    }

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
