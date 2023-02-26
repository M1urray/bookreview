package com.example.review.service.implementations;

import com.example.review.dto.AuthorDTO;
import com.example.review.exception.ResourceNotFound;
import com.example.review.model.Authors;
import com.example.review.repository.AuthorsRepository;
import com.example.review.service.AuthorsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorsServiceImpl implements AuthorsService {
    @Autowired
    private final AuthorsRepository authorsRepository;

    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public List<Authors> getAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors saveAuthor(AuthorDTO authorDTO) {
        Authors authors = new Authors();
        authors.setName(authorDTO.getName());
        authors.setBio(authorDTO.getBio());
        return authorsRepository.save(authors);
    }

}
