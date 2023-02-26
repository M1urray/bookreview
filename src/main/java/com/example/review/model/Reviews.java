package com.example.review.model;

import jakarta.persistence.*;


import java.util.Date;
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
@Table(name="reviews")
public class Reviews {
	public Reviews(Long id, Long isbn, String name, String review, Long date, Integer rate, Books book, Date createdAt, Date updatedAt) {
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.review = review;
		this.date = date;
		this.rate = rate;
		this.book = book;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="isbn")
	private Long isbn;

	@Column(name="name")
	private String name;

	@Column(name="review")
	private String review;

	@Column(name="date")
	private Long date;

	@Column(name="rate")
	private Integer rate;

	@ManyToOne
	@JoinColumn(name="book_id")
	private Books book;



	public Reviews() {

	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

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

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
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
	public void updateFields(Reviews r) {
		this.id = r.getId();
		this.isbn = r.getIsbn();
		this.name = r.getName();
		this.review = r.getReview();
		this.date = r.getDate();
		this.rate = r.getRate();
	}
}
