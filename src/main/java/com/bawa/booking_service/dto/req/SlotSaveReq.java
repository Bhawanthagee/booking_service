package com.bawa.booking_service.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SlotSaveReq {

    private LocalDate date;

    private LocalTime start;

    private LocalTime end;

    private Integer mentorId;

}
