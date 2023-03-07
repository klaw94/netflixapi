package com.example.netflixdatabaseapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LikedMovie {
        private final Integer id;
        private final Integer employeeId;
        private final String media_type;


        private final String status;

        public LikedMovie(@JsonProperty("id") Integer id,
                          @JsonProperty("employeeid") Integer employeeId,
                          @JsonProperty("media_type") String media_type,
                          @JsonProperty("status") String status){
            this.id = id;
            this.employeeId = employeeId;
            this.media_type = media_type;
            this.status = status;
        }


        public int getId() {
            return id;
        }

        public String getMediaType() {
            return media_type;
        }

        public String getStatus() {
            return status;
        }

        public int getEmployeeId() { return employeeId; }



}
