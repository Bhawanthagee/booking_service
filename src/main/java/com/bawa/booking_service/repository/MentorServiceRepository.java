package com.bawa.booking_service.repository;

import com.bawa.booking_service.entity.MentorService;
import com.bawa.booking_service.util.results.ServiceResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorServiceRepository extends JpaRepository<MentorService, Integer> {
    @Query(value = """
            SELECT 
                s.service_id as id,
                s.name as name,
                p.amount as price,
                p.mentor_id as mentorId
            
                FROM service s 
                LEFT JOIN price p ON s.service_id = p.service_id
                WHERE p.mentor_id = :mentorId                     
            """,nativeQuery = true)
    List<ServiceResults> findByMentorId(@Param("mentorId") Integer mentorId);
}
