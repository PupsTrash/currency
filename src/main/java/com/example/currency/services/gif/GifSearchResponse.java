package com.example.currency.services.gif;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GifSearchResponse {
    private List<GifData> data;


    @Data
    static class GifData {
        @JsonIgnore
        String user;
        @JsonIgnore
        String analytics_response_payload;
        @JsonIgnore
        String analytics;
        private String type;
        private String id;
        private String title;
        private Map<String, Image> images;

        @Data
        static class Image {
            private String height;
            private String width;
            private String size;
            private String url;
        }
    }
}


