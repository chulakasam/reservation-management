package com.ceyentra.reservation_management.service.Impl;



import com.ceyentra.reservation_management.dao.UserDAO;
import com.ceyentra.reservation_management.dto.PasswordDto;
import com.ceyentra.reservation_management.dto.UserDto;
import com.ceyentra.reservation_management.entity.User;
import com.ceyentra.reservation_management.exception.NotFoundException;
import com.ceyentra.reservation_management.secure.Response.JWTAuthResponse;
import com.ceyentra.reservation_management.secure.Security.SignIn;
import com.ceyentra.reservation_management.secure.Security.SignUp;
import com.ceyentra.reservation_management.service.AuthenticationService;
import com.ceyentra.reservation_management.service.JwtService;
import com.ceyentra.reservation_management.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final Mapping mapping;
    private final UserDAO userDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signUp(SignUp signUp) {
        UserDto userDTO =UserDto.builder().email(signUp.getEmail()).password(passwordEncoder.encode(signUp.getPassword())).role(String.valueOf(signUp.getRole())).build();
        User userEntity1 = mapping.toUserEntity(userDTO);
        System.out.println(userEntity1);
        userDao.save(userEntity1);
        System.out.println(userEntity1);
        String generateToken = jwtService.generateToken(userEntity1);
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        User userEntity=userDao.findByEmail(signIn.getEmail()).orElseThrow(()->new NotFoundException("User Not Found"));
        var generateToken = jwtService.generateToken( userEntity);
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String refreshToken) {
        String user =jwtService.extractUserName(refreshToken);
        User findUser =userDao.findByEmail(user).orElseThrow(()-> new NotFoundException("Couldn't find User"));
        String token =jwtService.refreshToken((UserDetails) findUser);
        return JWTAuthResponse.builder().token(token).build();
    }
    @Override
    public void changePassword(PasswordDto passwordDto) {
        Optional<User> byEmail =userDao.findByEmail(passwordDto.getEmail());
        if (byEmail.isPresent()){
            User userEntity=userDao.getReferenceById(Integer.valueOf(byEmail.get().getEmail()));
            userEntity.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
            userDao.save(userEntity);
        }
    }
}
