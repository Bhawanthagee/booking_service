package com.bawa.booking_service.repository;

import com.bawa.booking_service.BookingResults;
import com.bawa.booking_service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = """
            SELECT 
                b.book_id AS bookId,
                b.user_id AS menteeId,
                s.mentor_id AS mentorId,
                s.date AS date,
                s.start AS startTime,
                s.end AS endTime,
                b.bk_status AS bookStatus
            FROM book b
            JOIN slot s ON b.slot_id = s.slot_id
            WHERE b.user_id = :menteeId
            """, nativeQuery = true)
    List<BookingResults> getAllByMentee(@Param("menteeId") Integer menteeId);

    @Query(value = """
                    SELECT\s
                        b.book_id AS bookId,
                        b.user_id AS menteeId,
                        s.mentor_id AS mentorId,
                        s.date AS date,
                        s.start AS startTime,
                        s.end AS endTime,
                        b.bk_status AS bookStatus,
                        s.is_booked AS isBooked
                    FROM slot s
                    LEFT JOIN book b ON s.slot_id = b.slot_id
                    WHERE s.mentor_id = :mentorId;
            """, nativeQuery = true)
    List<BookingResults> getAllByMentor(@Param("mentorId") Integer mentorId);

    @Query(value = """
            SELECT 
                b.book_id AS bookId,
                b.user_id AS menteeId,
                s.mentor_id AS mentorId,
                s.date AS date,
                s.start AS startTime,
                s.end AS endTime,
                b.bk_status AS bookStatus,
                s.is_booked AS isBooked
            FROM slot s
            LEFT JOIN book b ON s.slot_id = b.slot_id
            WHERE b.book_id = :bookingId
            """, nativeQuery = true)
    BookingResults getByBookingId(@Param("bookingId") Integer bookingId);
}
