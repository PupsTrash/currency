package com.example.currency.services.gif;

import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@FeignClient(
        url = "${giphyServiceVariable.source}",
        name = "SearchGif", configuration = SearchGif.ClientConfig.class
)
public interface SearchGif {
    @RequestLine("GET /gifs/search?q={query}&limit={limit}&offset={offset}&api_key={api_key}")
    @Headers("Content-Type: application/json")
    GifSearchResponse response(@Param("query") String query,
                               @Param("limit") String limit,
                               @Param("offset") String offset,
                               @Param("api_key") String api_key);


    class ClientConfig {
        @Bean
        public AsyncFeign.AsyncBuilder feignBuilder() {
            return AsyncFeign.asyncBuilder();
        }

        @Bean
        public Contract feignContract() {
            return new feign.Contract.Default();
        }
    }
}

