package com.example.review.repository;

import com.example.review.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
    List<Reviews> findAll();

    List<Reviews> findByIsbnOrderByDateDesc(long isbn);

    Optional<Reviews> findByreview_id(int id);
}