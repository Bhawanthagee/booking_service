package com.bawa.booking_service.service.impl;

import com.bawa.booking_service.dto.req.SlotSaveReq;
import com.bawa.booking_service.dto.req.SlotUpdateReq;
import com.bawa.booking_service.entity.Slot;
import com.bawa.booking_service.exception.UserNotFoundException;
import com.bawa.booking_service.repository.SlotRepository;
import com.bawa.booking_service.service.SlotService;
import com.bawa.booking_service.util.mapper.SlotMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    SlotRepository repository;

    @Autowired
    SlotMapper slotMapper;

    @Override
    public void createSlot(SlotSaveReq slotSaveReq) {
        Slot slotToSave = slotMapper.reqToEntity(slotSaveReq);
        slotToSave.setIsBooked(false);
        repository.save(slotToSave);
    }

    @Override
    public void updateSlot(Integer slotId, SlotUpdateReq slotUpdateReq) {
        Slot existingSlot = repository.findById(slotId)
                .orElseThrow(() -> new UserNotFoundException("Slot not found with id: " + slotId));

        Slot slotToBeUpdated = slotMapper.updateReqToEntity(slotUpdateReq);
        slotToBeUpdated.setSlotId(slotId);
        repository.save(slotToBeUpdated);

    }

    @Override
    public void deleteSlot(Integer slotId) {
        Slot existingSlot = repository.findById(slotId)
                .orElseThrow(() -> new UserNotFoundException("Slot not found with id: " + slotId));

        repository.deleteById(slotId);
    }

    @Override
    public List<Slot> findAllByMentor(Integer mentorId) {
        return repository.findAllByMentorId(mentorId);
    }

    @Override
    public Slot findById(Integer slotId) {
        return repository.findById(slotId).orElseThrow(
                ()->new UserNotFoundException("Slot not found for id: "+slotId)
        );
    }
}
