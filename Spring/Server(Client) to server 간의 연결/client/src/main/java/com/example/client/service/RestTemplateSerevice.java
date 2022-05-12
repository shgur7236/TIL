package com.example.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateSerevice {

    //  http://localhost/api/server/hello
    // response
    public String hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();


    }
}
