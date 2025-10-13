package com.bawa.booking_service.service.impl;

import com.bawa.booking_service.dto.res.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserClient {

    private final RestTemplate restTemplate;

    @Autowired
    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse getUserById(Integer userId) {
        String url = "http://localhost:8081/app_user?" + userId;
        return restTemplate.getForObject(url, UserResponse.class);
    }
}