package com.bawa.booking_service.util.mapper;
import com.bawa.booking_service.dto.req.SlotSaveReq;
import com.bawa.booking_service.dto.req.SlotUpdateReq;
import com.bawa.booking_service.entity.Slot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SlotMapper {
    Slot reqToEntity(SlotSaveReq slotSaveReq);

    Slot updateReqToEntity(SlotUpdateReq slotUpdateReq);
}
