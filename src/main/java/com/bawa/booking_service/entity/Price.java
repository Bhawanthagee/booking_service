package com.bawa.booking_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "price")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer priceId;

    @Column(name = "mentor_id", nullable = false)
    private Integer mentorId;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name="amount")
    private Double amount;
}