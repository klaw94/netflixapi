package com.example.netflixdatabaseapi.requestmodels;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WatchlistMovieRequestModel {
    private final Integer id;
    private final Integer userId;
    private final String media_type;
    private final String backdrop_path;

    public WatchlistMovieRequestModel(@JsonProperty("id") Integer id,
                                      @JsonProperty("employeeid") Integer userId,
                                      @JsonProperty("media_type") String media_type,
                                      @JsonProperty("backdrop_path") String backdrop_path){
        this.id = id;
        this.userId= userId;
        this.media_type = media_type;
        this.backdrop_path = backdrop_path;
    }


    public int getId() {
        return id;
    }

    public int getUserId(){ return userId; }

    public String getMediaType() {
        return media_type;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

}

