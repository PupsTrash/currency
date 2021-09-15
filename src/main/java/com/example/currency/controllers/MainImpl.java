package com.example.currency.controllers;

import com.example.currency.controllers.api.MainGetRequest;
import com.example.currency.services.MainService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainImpl {
    private final MainService service;


    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(schema = @Schema(implementation = MainGetRequest.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE))

    @PostMapping
    ResponseEntity<Resource> main(@RequestBody MainGetRequest request) throws IOException {

        byte[] gif = service.get(request);
        ByteArrayResource resource = new ByteArrayResource(gif);

        return ResponseEntity.ok()
                .contentLength(gif.length)
                .contentType(MediaType.IMAGE_GIF)
                .body(resource);
    }
}
