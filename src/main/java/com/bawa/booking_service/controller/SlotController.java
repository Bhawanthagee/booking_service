package com.bawa.booking_service.controller;

import com.bawa.booking_service.dto.req.SlotSaveReq;
import com.bawa.booking_service.dto.req.SlotUpdateReq;
import com.bawa.booking_service.dto.res.StandardResponse;
import com.bawa.booking_service.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("slot")
@CrossOrigin(origins = "${cross.origins}", allowedHeaders = "${cross.allowedHeaders}")
public class SlotController {
    @Autowired
    SlotService slotService;

    @PostMapping("create_slot")
    public ResponseEntity<StandardResponse>createSlot(
            @RequestBody SlotSaveReq slotSaveReq
            ){
        slotService.createSlot(slotSaveReq);
        return new ResponseEntity<>(
                new StandardResponse("Success","Slot Created Successfully!"),HttpStatus.OK
        );
    }
    @GetMapping("get_all_by_mentor")
    public ResponseEntity<StandardResponse>getAllByMentor(
            @RequestParam Integer mentorId
    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",slotService.findAllByMentor(mentorId)),HttpStatus.OK
        );
    }
    @GetMapping("get_by_id")
    public ResponseEntity<StandardResponse>getById(
            @RequestParam Integer slotId
    ){
        return new ResponseEntity<>(
                new StandardResponse("Success",slotService.findById(slotId)),HttpStatus.OK
        );
    }

    @PatchMapping("update_slot")
    public ResponseEntity<StandardResponse>updateSlot(
            @RequestParam Integer slotId,
            @RequestBody SlotUpdateReq slotUpdateReq
    ){
        slotService.updateSlot(slotId,slotUpdateReq);
        return new ResponseEntity<>(
                new StandardResponse("Sucess","Slot Updated Successfully"),HttpStatus.OK
        );
    }
    @DeleteMapping("delete_slot")
    public ResponseEntity<StandardResponse>deleteSlot(
            @RequestParam Integer slotId
    ){
        slotService.deleteSlot(slotId);
        return new ResponseEntity<>(
                new StandardResponse("Success","Slot Deleted successfully"),HttpStatus.OK
        );
    }
}
