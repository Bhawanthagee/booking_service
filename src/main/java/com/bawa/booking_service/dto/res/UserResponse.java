package com.bawa.booking_service.dto.res;

import com.bawa.booking_service.contrains.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserResponse {

    private String id;

    private String email;

    private String name;

    private Role role;
}
