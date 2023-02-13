package com.example.review.controllers;

import com.example.review.model.Books;
import com.example.review.implementations.BooksAuthorsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private final BooksAuthorsServiceImpl booksAuthorsService;

    public BookController(BooksAuthorsServiceImpl booksAuthorsService) {
        this.booksAuthorsService = booksAuthorsService;
    }

    @GetMapping("/books/{isbn}")
    public Books searchBook(@PathVariable String isbn) throws JsonProcessingException {
        return booksAuthorsService.saveBook(isbn);
    }
}
