package com.example.currency.services.currency;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponse {
    private String base;
    private Map<String, Float> rates;
}
