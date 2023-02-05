package com.example.review.repository;

import com.example.review.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
}