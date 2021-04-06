package com.example.demo.service.impl;

import com.example.demo.auth.LoginRequestDTO;
import com.example.demo.auth.RegistrationRequestDTO;
import com.example.demo.auth.Role;
import com.example.demo.auth.User;
import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.exceptionHandling.UserDuplicateException;
import com.example.demo.service.api.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private RoleMapper roleMapper;

    @Autowired
    public AuthenticationServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public Authentication authorize(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getLogin(), loginRequestDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }

    @Override
    public User register(RegistrationRequestDTO registrationRequestDTO) {
        userMapper.getByLogin(registrationRequestDTO.getUsername())
                .ifPresent((account)-> {
                    throw new UserDuplicateException("Such user already exists");
                });
        return createAccount(registrationRequestDTO);
    }

    @Override
    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private User createAccount(RegistrationRequestDTO registrationRequestDTO) {
        User account = new User();
        Set<Role> roles = new HashSet<>();
        int roleId = registrationRequestDTO.getRole_id();

        account.setPassword(passwordEncoder.encode(registrationRequestDTO.getPassword()));
        account.setUsername(registrationRequestDTO.getUsername());

        userMapper.addUser(account);
        userMapper.addRoleToUser(account.getUserId(),roleId);

        Role role = roleMapper.getRoleById(registrationRequestDTO.getRole_id());
        roles.add(role);
        account.setRoles(roles);
        return account;
    }

}
