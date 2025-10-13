package com.bawa.booking_service.service.impl;

import com.bawa.booking_service.BookingResults;
import com.bawa.booking_service.contrains.BookingStatus;
import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.dto.res.UserResponse;
import com.bawa.booking_service.entity.Booking;
import com.bawa.booking_service.repository.BookingRepository;
import com.bawa.booking_service.service.BookingService;
import com.bawa.booking_service.util.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingMapper bookingMapper;
    @Autowired
    UserClient userClient;
    @Autowired
    WebClient webClient;

    @Override
    public void createBooking(BookCreateReq bookCreateReq) {
        Booking bookingToBeSaved = bookingMapper.saveReqToEntity(bookCreateReq);
        bookingToBeSaved.setBkStatus(BookingStatus.PENDING);
    }

    @Override
    public List<BookingResults> getAllByMentee(Integer menteeId) {
        UserResponse user = webClient.get()
                .uri("/appUserId=", menteeId)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return List.of();
    }
}
