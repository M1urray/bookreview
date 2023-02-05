package com.example.review.service;

import com.example.review.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Users saveUser(Users user);
    Optional<Users> getUser(String username);
    List<Users> getUsers();
}
