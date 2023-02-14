package com.example.review.service.implementations;

import com.example.review.clients.OpenApiClient;
import com.example.review.model.Authors;
import com.example.review.model.Books;
import com.example.review.repository.AuthorsRepository;
import com.example.review.repository.BooksRepository;
import com.example.review.service.BooksAuthorsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksAuthorsServiceImpl implements BooksAuthorsService {
    @Autowired
    private final OpenApiClient openApiClient;
    @Autowired
    private final BooksRepository booksRepository;
    @Autowired
    private final AuthorsRepository authorsRepository;

    public BooksAuthorsServiceImpl(OpenApiClient openApiClient, BooksRepository booksRepository, AuthorsRepository authorsRepository) {
        this.openApiClient = openApiClient;
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
    }

    @Override @Transactional
    public Books saveBook(String isbn) throws JsonProcessingException {
        String response = openApiClient.searchBooks(isbn);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);
        JsonNode bookNode = root.get(isbn);
        String title = bookNode.get("title").textValue();
        JsonNode authorNode = bookNode.get("authors");
        String authorName = authorNode.get(0).get("name").textValue();

        // Use the extracted information to populate a Book and Author object
        Books book = new Books();
        book.setIsbn(isbn);
        book.setTitle(title);
        booksRepository.save(book);
        Authors author = new Authors();
        author.setName(authorName);
        authorsRepository.save(author);
        return book;
    }
}
