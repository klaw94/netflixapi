package com.example.netflixdatabaseapi.responsemodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FavouriteGenreResponseModel {
    private final Integer genre_id;
    private final Integer employeeId;
    private Integer score;

    private final String genre_name;

    public FavouriteGenreResponseModel(Integer genre_id,
                                       Integer employeeId,
                                       Integer score,
                                       String genre_name) {
        this.genre_id = genre_id;
        this.employeeId = employeeId;
        this.score = score;
        this.genre_name = genre_name;
    }



    public int getGenreId() {
        return genre_id;
    }

    public int getScore() {
        return score;
    }

    public int getEmployeeId() { return employeeId; }

    public String getGenreName(){ return genre_name;}
}
