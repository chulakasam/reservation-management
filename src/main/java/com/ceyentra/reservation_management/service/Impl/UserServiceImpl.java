package com.ceyentra.reservation_management.service.Impl;

import com.ceyentra.reservation_management.dao.UserDAO;
import com.ceyentra.reservation_management.dto.UserWithKey;
import com.ceyentra.reservation_management.entity.User;
import com.ceyentra.reservation_management.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDAO.findByEmail(username).orElseThrow(()->new UserNotFoundException("User Name Not Found"));
    }

    @Override
    public boolean sendCodeToChangePassword(UserWithKey userWithKey) {
        Optional<User> byEmail=userDAO.findByEmail((userWithKey.getEmail()));
        if (byEmail.isPresent()){
            return true;
        }
        return false;
    }
}
