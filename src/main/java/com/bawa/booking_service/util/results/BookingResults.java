package com.bawa.booking_service.util.results;

import java.time.LocalDate;
import java.time.LocalTime;

    public interface BookingResults {
        Integer getBookId();
        Integer getMenteeId();
        Integer getMentorId();
        LocalDate getDate();
        LocalTime getStartTime();
        LocalTime getEndTime();
        String getBookStatus();
    }
