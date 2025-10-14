package com.bawa.booking_service.service.impl;

import com.bawa.booking_service.BookingResults;
import com.bawa.booking_service.contrains.BookingStatus;
import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.dto.req.SlotUpdateReq;
import com.bawa.booking_service.dto.res.BookingResDto;
import com.bawa.booking_service.dto.res.StandardResponse;
import com.bawa.booking_service.dto.res.UserResponse;
import com.bawa.booking_service.entity.Booking;
import com.bawa.booking_service.entity.Slot;
import com.bawa.booking_service.exception.SlotAlreadyBookedException;
import com.bawa.booking_service.repository.BookingRepository;
import com.bawa.booking_service.service.BookingService;
import com.bawa.booking_service.service.SlotService;
import com.bawa.booking_service.util.mapper.BookingMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingMapper bookingMapper;
    @Autowired
    UserClient userClient;
    @Autowired
    WebClient webClient;
    @Autowired
    SlotService slotService;

    @Override
    public void createBooking(BookCreateReq bookCreateReq) {

        Slot existingSlot = slotService.findById(bookCreateReq.getSlotId());
        if (existingSlot.getIsBooked()) {
            throw new SlotAlreadyBookedException("Slot ID: " + existingSlot.getSlotId() + " is already booked");
        }

        slotService.updateSlot(existingSlot.getSlotId(), SlotUpdateReq.builder()
                .isBooked(true)
                .date(existingSlot.getDate())
                .start(existingSlot.getStart())
                .end(existingSlot.getEnd())
                .mentorId(existingSlot.getMentorId())
                .build());

        Booking bookingToBeSaved = bookingMapper.saveReqToEntity(bookCreateReq);
        bookingToBeSaved.setBkStatus(BookingStatus.PENDING);

        bookingRepository.save(bookingToBeSaved);
    }

    @Override
    public List<BookingResDto> getAllByMentee(Integer menteeId, Integer mentorId) {
        ObjectMapper mapper = new ObjectMapper();

        List<BookingResults> result = bookingRepository.getAllByMentee(menteeId);
        List<BookingResDto> resDtoList = bookingMapper.customResultToDto(result);

        List<Integer> mentorIds = resDtoList.stream()
                .map(BookingResDto::getMentorId)
                .toList();

        StandardResponse response = webClient.post()
                .uri("/get_mentors_by_id")
                .bodyValue(mentorIds)
                .retrieve()
                .bodyToMono(StandardResponse.class)
                .block();

        Object data = response.getData();
        ObjectMapper objMapper = new ObjectMapper();
        List<UserResponse> mentors = objMapper.convertValue(
                data,
                new TypeReference<List<UserResponse>>() {
                }
        );

        Map<Integer, UserResponse> mentorMap = mentors.stream()
                .collect(Collectors.toMap(UserResponse::getId, m -> m));

        resDtoList.forEach(dto -> {
            UserResponse mentor = mentorMap.get(dto.getMentorId());
            if (mentor != null) {
                dto.setMentorName(mentor.getName());
            }
        });

        return resDtoList;
    }

    @Override
    public String cancelOrConfirmBooking(Integer bookingId, BookingStatus status) {
        Booking existingBooking = bookingRepository.findById(bookingId).orElseThrow(
                () -> new EntityNotFoundException("Booking with ID: " + bookingId + " does not exist"));
        Slot existingSlot = slotService.findById(existingBooking.getSlotId());
        existingBooking.setBkStatus(status);
        bookingRepository.save(existingBooking);
        if (status == BookingStatus.CANCELLED) {
            slotService.updateSlot(existingBooking.getSlotId(), SlotUpdateReq.builder()
                    .mentorId(existingSlot.getMentorId())
                    .isBooked(false)
                    .end(existingSlot.getEnd())
                    .start(existingSlot.getStart())
                    .date(existingSlot.getDate())
                    .build());
        }
        return "Booking " + status;
    }
}
