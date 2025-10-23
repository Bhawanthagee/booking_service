package com.bawa.booking_service.repository;

import com.bawa.booking_service.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer> {
}
