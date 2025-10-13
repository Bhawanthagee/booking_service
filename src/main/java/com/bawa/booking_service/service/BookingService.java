package com.bawa.booking_service.service;

import com.bawa.booking_service.BookingResults;
import com.bawa.booking_service.dto.req.BookCreateReq;

import java.util.List;

public interface BookingService {
    void createBooking(BookCreateReq bookCreateReq);

    List<BookingResults> getAllByMentee(Integer menteeId);
}