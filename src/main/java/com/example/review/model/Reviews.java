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
	@Column(name="review_id")
	private Long review_id;

	@ManyToOne
	@JoinColumn(name="book_id")
	private Books book;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users username;

	
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

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
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

	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
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
