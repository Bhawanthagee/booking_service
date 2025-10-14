package com.bawa.booking_service.controller;

import com.bawa.booking_service.contrains.BookingStatus;
import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.dto.res.StandardResponse;
import com.bawa.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
@CrossOrigin(origins = "${cross.origins}", allowedHeaders = "${cross.allowedHeaders}")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping()
    public ResponseEntity<StandardResponse>bookSlot(
            @RequestBody BookCreateReq bookCreateReq
            ){
        bookingService.createBooking(bookCreateReq);
        return new ResponseEntity<>(
                new StandardResponse("Success","Booked Success"), HttpStatus.OK
        );
    }
    @GetMapping("Get_by_mentee")
    public ResponseEntity<StandardResponse>getByMentee(
            @RequestParam Integer menteeId,
            @RequestParam Integer mentorId
    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",bookingService.getAllByMentee(menteeId,mentorId)),HttpStatus.OK
        );
    }
    @PatchMapping("confirm_cancel_booking")
    public ResponseEntity<StandardResponse>cancelOrConfirmBooking(
            @RequestParam Integer bookingId,
            @RequestParam BookingStatus status,
            @RequestParam Integer slotId
    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",bookingService.cancelOrConfirmBooking(bookingId,status)),HttpStatus.OK
        );
    }
}
