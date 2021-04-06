package com.example.demo.controller;

import com.example.demo.auth.LoginRequestDTO;
import com.example.demo.auth.RegistrationRequestDTO;
import com.example.demo.auth.User;
import com.example.demo.exceptionHandling.UserDuplicateEntity;
import com.example.demo.exceptionHandling.UserDuplicateException;
import com.example.demo.service.api.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDTO loginRequestDTO) {
        authenticationService.authorize(loginRequestDTO);
    }

    @PostMapping("/logout")
    public void logout() {
        authenticationService.logout();
    }


    @PostMapping("/register")
    public User register(@RequestBody @Validated RegistrationRequestDTO registrationRequestDTO) {
        return authenticationService.register(registrationRequestDTO);
    }

    @PostMapping("/current")
    public Principal current(Principal principal) {
        return principal;
    }


    @ExceptionHandler
    public ResponseEntity<UserDuplicateEntity> handleException (UserDuplicateException exception) {
        UserDuplicateEntity user = new UserDuplicateEntity();
        user.setInfo(exception.getMessage());
        return new ResponseEntity<>(user, HttpStatus.NOT_ACCEPTABLE);
    }
}
