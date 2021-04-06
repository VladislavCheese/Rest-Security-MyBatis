package com.example.demo.service.api;

import com.example.demo.auth.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppUserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
