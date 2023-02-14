package com.example.review.service;

import com.example.review.model.Books;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BooksAuthorsService {
    Books saveBook(String isbn ) throws JsonProcessingException;
}
