package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class User {

    private final Integer id;
    @NotBlank
    private final String name;

    public User(@JsonProperty("id") Integer id,
                 @JsonProperty("name") String name){
        this.id = id;
        this.name = name;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
