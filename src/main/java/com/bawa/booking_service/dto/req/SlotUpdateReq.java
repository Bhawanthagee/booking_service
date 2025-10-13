package com.bawa.booking_service.dto.req;

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
public class SlotUpdateReq {
    private LocalDate date;

    private LocalTime start;

    private LocalTime end;

    private Integer mentorId;

    private Boolean isBooked;
}
