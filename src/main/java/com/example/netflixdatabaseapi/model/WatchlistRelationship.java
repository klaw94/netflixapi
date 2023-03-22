package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class WatchlistRelationship {
    private final Integer user_id;
    private final Integer media_id;
    private final String media_type;

    public WatchlistRelationship(Integer user_id,
                    Integer media_id,
                    String media_type){
        this.user_id = user_id;
        this.media_type = media_type;
        this.media_id = media_id;
    }


    public int getUserId() {
        return user_id;
    }

    public String getMediaType() {
        return media_type;
    }

    public int getMedia_id() {
        return media_id;
    }

}

