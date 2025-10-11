package com.bawa.booking_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class AvailabilitySlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false) private
    Integer mentorId;  // FK to MentorProfile.id (app-side)
    @Column(nullable=false)
    private LocalDateTime slotStart;
    @Column(nullable=false)
    private LocalDateTime slotEnd;
    @Column(nullable=false)
    private boolean isBooked = false;
}
