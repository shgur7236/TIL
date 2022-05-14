package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateSerevice restTemplateSerevice;

    public ApiController(RestTemplateSerevice restTemplateSerevice) {
        this.restTemplateSerevice = restTemplateSerevice;
    }

    @GetMapping("/hello")
    public UserResponse getHello(){
        restTemplateSerevice.exchange();
        return new UserResponse();
    }
}
