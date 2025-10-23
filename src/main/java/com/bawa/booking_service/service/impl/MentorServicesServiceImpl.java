package com.bawa.booking_service.service.impl;

import com.bawa.booking_service.entity.MentorService;
import com.bawa.booking_service.entity.Price;
import com.bawa.booking_service.repository.MentorServiceRepository;
import com.bawa.booking_service.repository.PriceRepository;
import com.bawa.booking_service.service.MentorServicesService;
import com.bawa.booking_service.util.results.ServiceResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServicesServiceImpl implements MentorServicesService {
    @Autowired
    MentorServiceRepository mentorRepository;
    @Autowired
    PriceRepository priceRepository;

    @Override
    public String createService(Integer mentorId, String name, Double price) {
       MentorService savedService = mentorRepository.save(MentorService.builder()
                .name(name)
                .build());

        priceRepository.save(
                Price.builder()
                        .serviceId(savedService.getId())
                        .mentorId(mentorId)
                        .amount(price)
                        .build()
        );

        return "Saved Successfully";
    }

    @Override
    public List<ServiceResults> findAllById(Integer mentorId) {
        return mentorRepository.findByMentorId(mentorId);
    }
}
