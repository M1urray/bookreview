package com.example.review.dto;

import com.example.review.model.Books;
import com.example.review.model.Users;

public class ReviewDTO {
    private String user;
    private Integer rating;
    private String review;
    private Books book;
    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}