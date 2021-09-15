package com.example.currency.services.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {
    @Value("${currencyServiceVariable.app_id}")
    private String id;
    @Value("${currencyServiceVariable.base}")
    private String baseCurrency;

    private final Currency currency;


    public CurrencyResponse getCurrency(String currencyRequest, String date) {

        final CurrencyResponse currencyResponse = currency.response(id, baseCurrency, currencyRequest, date);
        log.info("currency = {} date: {}", currencyResponse.getRates(), date);
        return currencyResponse;
    }

    /**
     * if more 1.0 -> currency up
     * if less 1.0 -> currency down
     * if equal 1.0 -> currency don't change
     * @param currencyRequest
     * @return
     */

    public Float currencyRate24H(String currencyRequest){
        final CurrencyResponse currencyResponseNow = getCurrency(currencyRequest,
                LocalDate.now().toString());

        final CurrencyResponse currencyResponseYesterday = getCurrency(currencyRequest,
                LocalDate.now().minusDays(1L).toString());

        float currencyRate = currencyResponseNow.getRates().get(currencyRequest) / currencyResponseYesterday.getRates().get(currencyRequest);
        log.info("rate = {}", currencyRate);
        return currencyRate;
    }
}
