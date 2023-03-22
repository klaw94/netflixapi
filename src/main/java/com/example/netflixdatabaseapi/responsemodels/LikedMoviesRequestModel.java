package com.example.netflixdatabaseapi.responsemodels;

public class LikedMoviesRequestModel {
        private final Integer id;
        private final Integer employeeId;
        private final String media_type;


        private final String status;

        public LikedMoviesRequestModel(Integer id, Integer employeeId, String media_type, String status){
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
