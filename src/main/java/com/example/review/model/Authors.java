package com.example.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="author_id")
    private UUID author_id;

    @Column(name="name")
    private String name;
    @Column(name="bio")
    private String bio;
    @JsonIgnore
    @OneToMany(mappedBy ="author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Books> book;

    public UUID getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(UUID author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Books> getBook() {
        return book;
    }

    public void setBook(List<Books> book) {
        this.book = book;
    }
}
