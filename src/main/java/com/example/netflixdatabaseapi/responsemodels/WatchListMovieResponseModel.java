package com.example.netflixdatabaseapi.responsemodels;

import javax.validation.constraints.NotBlank;

public class WatchListMovieResponseModel {
    private final Integer id;
    private final Integer employeeId;
    private final String media_type;
    private final String backdrop_path;

    public WatchListMovieResponseModel(Integer id, Integer employeeId, String media_type, String backdrop_path){
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
