package com.example.currency.services;

import com.example.currency.controllers.api.MainGetRequest;
import com.example.currency.services.currency.CurrencyService;
import com.example.currency.services.gif.GifService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

@SpringBootTest
public class TestMainService {
    @MockBean
    CurrencyService currencyServiceMock;
    @Autowired
    private MainService mainService;
    @MockBean
    private GifService gifServiceMock;

    @Test
    public void testRich() throws IOException {
        final MainGetRequest request = new MainGetRequest();
        request.setCurrencyCode("RUB");
        Mockito.when(currencyServiceMock.currencyRate24H(request.getCurrencyCode())).thenReturn(1.5F);
        mainService.get(request);
        Mockito.verify(gifServiceMock, Mockito.times(1)).getGif(ArgumentMatchers.eq("rich"));
    }

    @Test
    public void testBroke() throws IOException {
        final MainGetRequest request = new MainGetRequest();
        request.setCurrencyCode("RUB");
        Mockito.when(currencyServiceMock.currencyRate24H(request.getCurrencyCode())).thenReturn(0.5F);
        mainService.get(request);
        Mockito.verify(gifServiceMock, Mockito.times(1)).getGif(ArgumentMatchers.eq("broke"));
    }

}
