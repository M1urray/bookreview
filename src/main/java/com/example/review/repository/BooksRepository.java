package com.example.review.repository;

import com.example.review.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BooksRepository extends JpaRepository<Books, Long> {

    Page<Books> findAll(Pageable pageable);

    Optional<Books> findById(Long book_id);
    List<Books> findByTitle(String title);
}