package com.example.currency.controllers.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MainGetRequest {

    @Schema(description = "currency (3-letter code) default: USD")
    private String currencyCode;
}
