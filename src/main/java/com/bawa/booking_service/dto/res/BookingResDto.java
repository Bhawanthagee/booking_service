package com.bawa.booking_service.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingResDto {
    private Integer bookId;
    private Integer menteeId;
    private Integer mentorId;
    private String mentorName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String bookStatus;
}
