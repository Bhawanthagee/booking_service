package com.bawa.booking_service.entity;
import com.bawa.booking_service.contrains.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "slot_id", nullable = false)
    private Integer slotId;

    @Column(name = "bk_status")
    @Enumerated(EnumType.STRING)
    private BookingStatus bkStatus = BookingStatus.PENDING;
}