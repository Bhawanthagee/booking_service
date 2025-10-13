package com.bawa.booking_service.service;

import com.bawa.booking_service.dto.req.SlotSaveReq;
import com.bawa.booking_service.dto.req.SlotUpdateReq;
import com.bawa.booking_service.entity.Slot;

import java.util.List;

public interface SlotService {
    void createSlot(SlotSaveReq slotSaveReq);

    void updateSlot(Integer slotId, SlotUpdateReq slotUpdateReq);

    void deleteSlot(Integer slotId);

    List<Slot> findAllByMentor(Integer mentorId);

    Slot findById(Integer slotId);
}
