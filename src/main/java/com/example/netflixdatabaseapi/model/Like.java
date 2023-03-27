package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Like {
    private final Integer media_id;
    private final Integer user_id;

    private final String like_type;
    private final String media_type;

    public Like(Integer media_id, Integer user_id, String like_type, String media_type) {
        this.media_id = media_id;
        this.user_id = user_id;
        this.like_type = like_type;
        this.media_type = media_type;
    }



    public int getMediaId() {
        return media_id;
    }
    public int getUserId() {
        return user_id;
    }

    public String getLikeType(){ return like_type;}
    public String getMediaType(){ return media_type;}
}
