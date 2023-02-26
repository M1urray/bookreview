package com.example.review.repository;

import com.example.review.model.Reviews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    Page<Reviews> findAll(Pageable pageable);

    List<Reviews> findByIsbnOrderByDateDesc(Long isbn);

    Optional<Reviews> findById(Long id);
}