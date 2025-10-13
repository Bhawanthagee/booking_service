package com.bawa.booking_service.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BookCreateReq {
    private Integer userId;

    private Integer slotId;
}
