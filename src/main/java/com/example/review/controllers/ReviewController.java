package com.example.review.controllers;

import com.example.review.exception.ResourceNotFound;
import com.example.review.model.Reviews;
import com.example.review.repository.ReviewsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api/v1")
public class ReviewController {
    private final ReviewsRepository reviewsRepository;

    public ReviewController(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    //get all reviews
    @GetMapping("/reviews")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    //get reviews by ISBN
    @GetMapping("/reviews/{isbn}")
    public List<Reviews> getReviewsByIsbn(@PathVariable long isbn) {
        return reviewsRepository.findByIsbnOrderByDateDesc(isbn);
    }

    //get review by ID
    @GetMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reviews> getReviewById(@PathVariable int id) {
        Reviews review = reviewsRepository.findByreview_id(id).orElseThrow(() ->  new ResourceNotFound("Review not found"));
        return ResponseEntity.ok(review);
    }

    //create new review
    @PostMapping("/review")
    public Reviews newReview(@RequestBody Reviews review) {
        long date = System.currentTimeMillis();
        review.setCreatedAt(date);
        return reviewsRepository.save(review);
    }

    //update review by ID
    @PutMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reviews> updateReview(@PathVariable int id, @RequestBody Reviews review) {
        Reviews r = reviewsRepository.findByreview_id(id).orElseThrow(() ->  new ResourceNotFound("Review not found"));
        r.updateFields(review);
        Reviews updatedReview = reviewsRepository.save(r);
        return ResponseEntity.ok(updatedReview);
    }

    //delete review by ID
    @DeleteMapping("/review/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteReview(@PathVariable UUID id) {
        if (!reviewsRepository.existsById(id)){
            throw new ResourceNotFound("Review not found");
        }
        reviewsRepository.deleteById(id);
        return "The review with id: "+ id +" is removed from the database.";
    }

}
