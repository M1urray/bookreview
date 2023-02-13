package com.example.review.repository;

import com.example.review.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorsRepository extends JpaRepository<Authors, UUID> {
    List<Authors> findByName(String name);
}