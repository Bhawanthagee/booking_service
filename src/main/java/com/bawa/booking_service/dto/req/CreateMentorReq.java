package com.bawa.booking_service.dto.req;

import com.bawa.booking_service.contrains.Seniority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMentorReq {
    @NotNull
    Integer userId;
    @NotBlank
    String domainsCsv;
    @NotNull
    Seniority seniority;
    @NotBlank
    String badgesCsv;
    @NotNull
    Integer rateCents;
}
