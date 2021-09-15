package com.example.currency.handlers;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(FeignException.class)
    public String handleCurrencyClientException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        log.error("feign clients exception");
        return "error connect to outer service";
    }
}
