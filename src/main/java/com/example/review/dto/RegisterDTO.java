package com.example.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDTO {
    private String username;
    private String password;
    private String firstname;
    private String email;
    private String lastname;
}
