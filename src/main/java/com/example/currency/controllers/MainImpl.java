package com.example.currency.controllers;

import com.example.currency.controllers.api.MainGetRequest;
import com.example.currency.services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainImpl {
    private final MainService service;

    @GetMapping
    @ResponseBody()
    ResponseEntity<Resource> main(@RequestBody MainGetRequest request) throws IOException {

        byte[] gif = service.get(request);
        ByteArrayResource resource = new ByteArrayResource(gif);

        return ResponseEntity.ok()
        .contentLength(gif.length)
        .contentType(MediaType.IMAGE_GIF)
        .body(resource);
    }
}
