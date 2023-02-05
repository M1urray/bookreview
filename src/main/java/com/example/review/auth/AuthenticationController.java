package com.example.review.auth;

import com.example.review.service.dto.LoginDto;
import com.example.review.service.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterDto registerDto
    ) {
        return ResponseEntity.ok(authenticationService.register(registerDto));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody LoginDto loginDto
            ) {
        return ResponseEntity.ok(authenticationService.authenticate(loginDto));
    }
}
