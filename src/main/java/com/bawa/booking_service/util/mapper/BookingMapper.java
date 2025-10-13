package com.bawa.booking_service.util.mapper;

import com.bawa.booking_service.dto.req.BookCreateReq;
import com.bawa.booking_service.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking saveReqToEntity(BookCreateReq bookCreateReq);
}
