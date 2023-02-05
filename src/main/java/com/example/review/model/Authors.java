package com.example.review.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="author_id")
    private UUID author_id;

    @Column(name="name")
    private String name;
    @Column(name="bio")
    private String bio;

}
