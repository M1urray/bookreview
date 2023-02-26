package com.example.review.controllers;

import com.example.review.dto.AuthorDTO;
import com.example.review.exception.ResourceNotFound;
import com.example.review.model.Authors;
import com.example.review.repository.AuthorsRepository;
import com.example.review.service.implementations.AuthorsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api/v1/authors")
public class AuthorsController {
    private final AuthorsServiceImpl authorsService;
    private final AuthorsRepository authorsRepository;


    public AuthorsController(AuthorsServiceImpl authorsService,
                             AuthorsRepository authorsRepository) {
        this.authorsService = authorsService;
        this.authorsRepository = authorsRepository;
    }

    @PostMapping
    public Authors addAuthor(@RequestBody AuthorDTO authorDTO){
        return authorsService.saveAuthor(authorDTO);
    }


    @PutMapping("/{id}")
    public Authors updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO ){
        Authors author =authorsRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Author Not Found"));
        author.setName(authorDTO.getName());
        author.setBio(authorDTO.getBio());
        Authors updatedAuthor = authorsRepository.save(author);
        return ResponseEntity.ok(updatedAuthor).getBody();
    }
    @DeleteMapping("/id")
    public String deleteAuthor(@PathVariable Long id){
        if (!authorsRepository.existsById(id)){
            throw new ResourceNotFound("Author not found");
        }
        authorsRepository.deleteById(id);
        return "The author with id: "+ id +" is removed from the database.";
    }

}
