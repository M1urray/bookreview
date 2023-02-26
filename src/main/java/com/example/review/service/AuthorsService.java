package com.example.review.service;

import com.example.review.dto.AuthorDTO;
import com.example.review.model.Authors;

import java.util.List;

public interface AuthorsService {
    List<Authors> getAuthors();

    Authors saveAuthor(AuthorDTO authorDTO);
}
