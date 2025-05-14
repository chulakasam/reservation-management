package com.ceyentra.reservation_management.service;


import com.ceyentra.reservation_management.dto.UserWithKey;

public interface UserService {
    UserDetailsService userDetailsService();
    boolean sendCodeToChangePassword(UserWithKey userWithKey);
}
