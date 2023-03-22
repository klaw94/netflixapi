package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {

    private final Integer genre_id;

    private final String genre_name;

    public Genre(@JsonProperty("genre_id") Integer genre_id,
                          @JsonProperty("genre_name") String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }



    public int getGenreId() {
        return genre_id;
    }

    public String getGenreName(){ return genre_name;}
}

