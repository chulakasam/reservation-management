package com.ceyentra.reservation_management.service;


import com.ceyentra.reservation_management.dto.PasswordDto;
import com.ceyentra.reservation_management.secure.Response.JWTAuthResponse;
import com.ceyentra.reservation_management.secure.Security.SignIn;
import com.ceyentra.reservation_management.secure.Security.SignUp;

public interface AuthenticationService {
    JWTAuthResponse signUp(SignUp signUp);
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse refreshToken(String refreshToken);
    void changePassword(PasswordDto passwordDto);
}
