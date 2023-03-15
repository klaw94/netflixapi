package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class FavouriteGenres {
    private final Integer genre_id;
    private final Integer employeeId;
    private Integer score;

    private final String genre_name;

    public FavouriteGenres(@JsonProperty("genre_id") Integer genre_id,
                 @JsonProperty("employeeid") Integer employeeId,
                           @JsonProperty("score") Integer score,
                           @JsonProperty("genre_name") String genre_name) {
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

    public void addToScore(int number) { score = score + number;}

    public int getEmployeeId() { return employeeId; }

    public String getGenreName(){ return genre_name;}
}
