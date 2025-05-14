package com.ceyentra.reservation_management.service;


import com.ceyentra.reservation_management.dto.UserWithKey;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    boolean sendCodeToChangePassword(UserWithKey userWithKey);
}
