package com.example.review.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    private String firstname;
    private String email;
    private String lastname;

}
