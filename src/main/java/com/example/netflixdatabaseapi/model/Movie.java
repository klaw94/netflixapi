package com.example.netflixdatabaseapi.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Movie {
    private final Integer id;
    private final Integer employeeId;
    @NotBlank
    private final String media_type;


    private final String backdrop_path;

    public Movie(@JsonProperty("id") Integer id,
                 @JsonProperty("employeeid") Integer employeeId,
                 @JsonProperty("media_type") String media_type,
                 @JsonProperty("backdrop_path") String backdrop_path){
        this.id = id;
        this.employeeId = employeeId;
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

    public int getEmployeeId() { return employeeId; }

}
