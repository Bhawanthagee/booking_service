package com.bawa.booking_service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BookingResults {
    String getMentorName();
    LocalDate getDate();
    LocalTime getStartTime();
    LocalTime getEndTime();
    String getBookStatus();
}
