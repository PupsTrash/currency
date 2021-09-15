package com.example.currency.services;

import com.example.currency.controllers.api.MainGetRequest;
import com.example.currency.services.currency.CurrencyService;
import com.example.currency.services.gif.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MainService {
    private final CurrencyService currencyService;
    private final GifService gifService;

    public byte[] get(MainGetRequest request) throws IOException {

        final Float rate24H = currencyService.currencyRate24H(request.getCurrencyCode());

        return rate24H >= 1.0F ? gifService.getGif("rich") : gifService.getGif("broke");

    }
}
