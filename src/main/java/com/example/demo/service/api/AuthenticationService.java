package com.example.demo.service.api;


import com.example.demo.auth.LoginRequestDTO;
import com.example.demo.auth.RegistrationRequestDTO;
import com.example.demo.auth.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication authorize(LoginRequestDTO loginRequestDTO);

    User register(RegistrationRequestDTO registrationRequestDTO);

    void logout();

}
