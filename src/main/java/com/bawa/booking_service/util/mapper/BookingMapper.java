package com.bawa.booking_service.util.mapper;

import com.bawa.booking_service.BookingResults;
import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.dto.res.BookingResDto;
import com.bawa.booking_service.entity.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking saveReqToEntity(BookCreateReq bookCreateReq);

    List<BookingResDto> customResultToDto(List<BookingResults> result);

    BookingResDto resultToRes(BookingResults result);
}
