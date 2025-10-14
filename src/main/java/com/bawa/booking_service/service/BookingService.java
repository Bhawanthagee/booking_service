package com.bawa.booking_service.service;

import com.bawa.booking_service.contrains.BookingStatus;
import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.dto.res.BookingResDto;

import java.util.List;

public interface BookingService {
    void createBooking(BookCreateReq bookCreateReq);

    List<BookingResDto> getAllByMentee(Integer menteeId, Integer mentorId);

    String cancelOrConfirmBooking(Integer bookingId, BookingStatus status);
}