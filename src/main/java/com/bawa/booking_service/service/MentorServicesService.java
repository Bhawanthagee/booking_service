package com.bawa.booking_service.service;

import com.bawa.booking_service.entity.MentorService;
import com.bawa.booking_service.util.results.ServiceResults;

import java.util.List;

public interface MentorServicesService {
    String createService(Integer mentorId, String name, Double price);

    List<ServiceResults> findAllById(Integer mentorId);

}
