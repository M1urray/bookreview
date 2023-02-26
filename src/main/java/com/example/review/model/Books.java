package com.example.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="books")
public class Books {
    public Books(Long book_id, String title, String description, Double price, String language, String genre, List<Reviews> reviews, Authors author, Date createdAt, String isbn, Date updatedAt) {
        this.book_id = book_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.language = language;
        this.genre = genre;
        this.reviews = reviews;
        this.author = author;
        this.createdAt = createdAt;
        this.isbn = isbn;
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(nullable=false)
    private String title;
    @Column(nullable = false,name="description")
    private String description;
    @Column(nullable = false,name="price")
    private Double price;
    @Column(nullable = false,name="language")
    private String language;

    @Column(nullable = false,name="genre")
    private String genre;
    @JsonIgnore
    @OneToMany(mappedBy ="book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reviews> reviews;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Authors author;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name="isbn")
    private String isbn;

    public Books() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updated")
    private Date updatedAt;

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
