package com.example.review.service.implementations;

import com.example.review.dto.ReviewDTO;
import com.example.review.model.Reviews;
import com.example.review.repository.ReviewsRepository;
import com.example.review.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewsRepository reviewsRepository;

    public ReviewServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public Reviews saveReview(ReviewDTO reviewDTO) {
        Reviews review = new Reviews();
        review.setUsername(reviewDTO.getUsername());
        review.setReview(reviewDTO.getReview());
        review.setRating(reviewDTO.getRating());
        review.setBook(reviewDTO.getBook());
        return reviewsRepository.save(review);
    }
}
