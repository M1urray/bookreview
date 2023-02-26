package com.example.review.service.implementations;

import com.example.review.dto.ReviewDTO;
import com.example.review.model.Reviews;
import com.example.review.repository.ReviewsRepository;
import com.example.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewsRepository reviewsRepository;

    public ReviewServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public Reviews saveReview(ReviewDTO reviewDTO) {
        Reviews review = new Reviews();
        review.setName(reviewDTO.getUser());
        review.setReview(reviewDTO.getReview());
        review.setRate(reviewDTO.getRating());
        review.setBook(reviewDTO.getBook());
        Long date = System.currentTimeMillis();
        review.setCreatedAt(new Date(date));
        return reviewsRepository.save(review);
    }
}
