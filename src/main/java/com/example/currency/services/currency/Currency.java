package com.example.currency.services.currency;

import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@FeignClient(name = "CurrencyClient",
        url = "${currencyServiceVariable.source}",
        configuration = Currency.ClientConfig.class)
public interface Currency {
    @RequestLine("GET /historical/{date}.json?app_id={app_id}&base={base}&symbols={symbols}")
    @Headers("Content-Type: application/json")
    CurrencyResponse response(@Param("app_id") String app_id,
                              @Param("base") String base,
                              @Param("symbols") String symbols,
                              @Param("date") String date);


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
