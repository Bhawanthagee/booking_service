package com.bawa.booking_service.entity;

import com.bawa.booking_service.contrains.Seniority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mentor_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private Integer userId;
    // from user_service
    @Column(nullable=false, length=512)
    private String domainsCsv;
    // "backend,devops"
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Seniority seniority;

    @Column(nullable=false, length=512)
    private String badgesCsv;
    // "system_design,interview_coach"
    @Column(nullable=false) private Integer rateCents;
}
