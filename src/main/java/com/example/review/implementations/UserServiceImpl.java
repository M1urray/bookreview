package com.example.review.implementations;

import com.example.review.model.Users;
import com.example.review.repository.UsersRepository;
import com.example.review.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j

public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }


    @Override
    public Optional<Users> getUser(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
}
