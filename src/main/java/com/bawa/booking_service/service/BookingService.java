package com.bawa.booking_service.service;

public interface BookingService {
    BookingRes create(CreateBookingReq req);
    BookingRes updateStatus(Integer id, BookingStatus status);
    List<BookingRes> listByMentee(Integer menteeId);
    List<BookingRes> listByMentor(Integer mentorId)
}
