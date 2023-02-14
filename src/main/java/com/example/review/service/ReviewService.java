package com.example.review.service;

import com.example.review.dto.ReviewDTO;
import com.example.review.model.Reviews;

public interface ReviewService {
    Reviews saveReview(ReviewDTO reviewDTO);
}
