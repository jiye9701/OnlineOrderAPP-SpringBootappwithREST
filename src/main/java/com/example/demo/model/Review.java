package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Review")
public class Review {
	@Id
	@Column (name="Id")
	private int id;
	
	@Column (name="data")
	private String name;
	
	@Column (name="userNo")
	private int userNo;
	
	@Column (name="userName")
	private String user;
	
	@Column (name="comment")
	private String comment;
	
	@Column (name="rating")
	private double rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Review() {}
	
	public Review(int id, String name, int userNo, String user, String comment, double rating) {
		super();
		
		this.id = id;
		this.name = name;
		
		this.userNo = userNo;
		this.user = user;
		this.comment = comment;
		this.rating = rating;
	}
	
	public Review(int userNo, String user, String comment, double rating) {
		super();
		
		
		this.userNo = userNo;
		this.user = user;
		this.comment = comment;
		this.rating = rating;
	}
	
	

}
