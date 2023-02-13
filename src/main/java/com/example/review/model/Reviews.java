package com.example.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
//+--------+---------------+------+-----+---------+----------------+
//| Field  | Type          | Null | Key | Default | Extra          |
//+--------+---------------+------+-----+---------+----------------+
//| id     | int           | NO   | PRI | NULL    | auto_increment |
//| name   | varchar(30)   | YES  |     | NULL    |                |
//| review | varchar(2000) | YES  |     | NULL    |                |
//| date   | bigint        | YES  |     | NULL    |                |
//| rate   | int           | YES  |     | NULL    |                |
//+--------+---------------+------+-----+---------+----------------+



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="book_id")
	private Books book;
	
	@Column(name="review")
	private String review;
	
	@Column(name="rating")
	private int rating;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated")
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
}
