package com.example.currency.services.gif;

import feign.RequestLine;
import feign.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface GifDownload {
    @RequestLine("GET ")
    @RequestMapping(method = RequestMethod.GET)
    Response download();
}
