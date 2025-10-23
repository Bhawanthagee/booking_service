package com.bawa.booking_service.controller;

import com.bawa.booking_service.dto.res.StandardResponse;
import com.bawa.booking_service.service.MentorServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
@CrossOrigin(origins = "${cross.origins}", allowedHeaders = "${cross.allowedHeaders}")
public class MentorServicesController {
    @Autowired
    MentorServicesService mentorServicesService;

    @PostMapping("save")
    public ResponseEntity<StandardResponse>saveService(
            @RequestParam String name,
            @RequestParam Integer mentorId,
            @RequestParam Double price
    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",mentorServicesService.createService(mentorId,name,price)), HttpStatus.OK
        );
    }
    @GetMapping("getById")
    public ResponseEntity<StandardResponse>getAllById(
            @RequestParam Integer mentorId

    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",mentorServicesService.findAllById(mentorId)),HttpStatus.OK
        );
    }

}
