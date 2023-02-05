package com.example.review.model;

import jakarta.persistence.*;
import lombok.Data;

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


@Data
@Entity
@Table(name="reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="id")
	private UUID id;
	
	@Column(name="name")
	private UUID user_id;
	@Column(name="book_id")
	private UUID book_id;
	
	@Column(name="review")
	private String review;
	
	@Column(name="date")
	private long date;
	
	@Column(name="rate")
	private int rate;
}
