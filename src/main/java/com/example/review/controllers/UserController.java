package com.example.review.controllers;

import com.example.review.model.Users;
import com.example.review.service.implementations.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api/v1/getUsers")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceimpl;
    @GetMapping
    public ResponseEntity<List<Users>> sayHello(){
        return  ResponseEntity.ok(userServiceimpl.getUsers());
    }
}
