package com.example.review.auth;

import com.example.review.configuration.JwtService;
import com.example.review.model.Role;
import com.example.review.model.Users;
import com.example.review.repository.UsersRepository;
import com.example.review.dto.LoginDTO;
import com.example.review.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsersRepository usersRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterDTO registerDto) {
        Users user;
        user = new Users();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstname(registerDto.getFirstname());
        user.setLastname(registerDto.getLastname());
        user.setEmail(registerDto.getEmail());
        user.setRole(Role.USER);
        usersRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(LoginDTO loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        Users user;
        user = usersRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        String jwtToken;
        jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse registerAdmin(RegisterDTO registerDto) {
        Users user;
        user = new Users();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstname(registerDto.getFirstname());
        user.setLastname(registerDto.getLastname());
        user.setEmail(registerDto.getEmail());
        user.setRole(Role.ADMIN);
        usersRepository.save(user);
        var message="Welcome ADMIN";
        return AuthenticationResponse.builder()
                .admin_message(message)
                .build();
    }
}
