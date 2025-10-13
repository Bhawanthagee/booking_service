package com.bawa.booking_service.repository;

import com.bawa.booking_service.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
    List<Slot> findAllByMentorId(Integer mentorId);
}
