package com.example.currency.services.gif;

import feign.AsyncFeign;
import feign.Response;
import feign.jackson.JacksonDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class GifService {
    private final SearchGif searchGif;

    @Value("${giphyServiceVariable.api_key}")
    private String id;

    public byte[] getGif(String query) throws IOException {
        final Integer randomInt = new Random().nextInt(1000);
        log.info("search gif with query {}", query);

        GifSearchResponse responseSearch = searchGif.response(query, "1", randomInt.toString(), id);
        log.info("download gif offset {}", randomInt);

        String url = responseSearch.getData().get(0)
                .getImages().get("original").getUrl();

        GifDownload gifDownload = AsyncFeign.asyncBuilder()
                .decoder(new JacksonDecoder())
                .target(GifDownload.class, url);


        Response responseDownload = gifDownload.download();
        return IOUtils.toByteArray(responseDownload.body().asInputStream());
    }
}
