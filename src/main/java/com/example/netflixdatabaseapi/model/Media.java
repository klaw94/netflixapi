package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Media {
    private final Integer id;
    @NotBlank
    private final String media_type;
    private final String backdrop_path;

    public Media(@JsonProperty("id") Integer id,
                 @JsonProperty("media_type") String media_type,
                 @JsonProperty("backdrop_path") String backdrop_path){
        this.id = id;
        this.media_type = media_type;
        this.backdrop_path = backdrop_path;
    }


    public int getId() {
        return id;
    }

    public String getMediaType() {
        return media_type;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

}
