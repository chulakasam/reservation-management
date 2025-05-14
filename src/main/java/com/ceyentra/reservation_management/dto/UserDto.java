package com.ceyentra.reservation_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto  {
    private String user_id;
    private String email;
    private String password;
    private String role;
}
