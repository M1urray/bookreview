package com.example.review.controllers;

import com.example.review.dto.ReviewDTO;
import com.example.review.exception.ResourceNotFound;
import com.example.review.model.Reviews;
import com.example.review.repository.ReviewsRepository;
import com.example.review.service.implementations.ReviewServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api/v1")
public class ReviewController {
    private final ReviewsRepository reviewsRepository;
    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewsRepository reviewsRepository, ReviewServiceImpl reviewService) {
        this.reviewsRepository = reviewsRepository;
        this.reviewService = reviewService;
    }

    //get all reviews
    @GetMapping("/reviews")
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Reviews> getAllReviews(@RequestParam int page, @RequestParam int size) {
        Pageable paging = PageRequest.of(page,size);
        return reviewsRepository.findAll(paging);
    }


    //create new review
    @PostMapping("/review")
    public ResponseEntity<String>newReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.saveReview(reviewDTO);
        String message="review has been created";
        return (ResponseEntity<String>) ResponseEntity.created(URI.create(message));
    }


    //get reviews by ISBN
    @GetMapping("/reviews/{isbn}")
    public List<Reviews> getReviewsByIsbn(@PathVariable Long isbn) {
        return reviewsRepository.findByIsbnOrderByDateDesc(isbn);
    }

    //get review by ID
    @GetMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long id) {
        Reviews review = reviewsRepository.findById(id).orElseThrow(() ->  new ResourceNotFound("Review not found"));
        return ResponseEntity.ok(review);
    }

    //update review by ID
    @PutMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reviews> updateReview(@PathVariable Long id, @RequestBody Reviews review) {
        Reviews r = reviewsRepository.findById(id).orElseThrow(() ->  new ResourceNotFound("Review not found"));
        r.updateFields(review);
        Reviews updatedReview = reviewsRepository.save(r);
        return ResponseEntity.ok(updatedReview);
    }
    //delete review by ID
    @DeleteMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteReview(@PathVariable Long id) {
        if (!reviewsRepository.existsById(id)){
            throw new ResourceNotFound("Review not found");
        }
        reviewsRepository.deleteById(id);
        return "The review with id: "+ id +" is removed from the database.";
    }

}
