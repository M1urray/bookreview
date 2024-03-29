package com.example.review.repository;

import com.example.review.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    List<Authors> findByName(String name);
}