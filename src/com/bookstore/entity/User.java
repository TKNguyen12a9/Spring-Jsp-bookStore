package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.fullName"), 
	@NamedQuery(name = "User.countAll", query = "SELECT Count(*) FROM User u"), 
})
public class User {
	private Integer userId;
	private String email;
	private String fullname;
	private String password;
	
	@Column(name = "user_id")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "full_name")
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "password") // Hibernate automatically know and integrate if the names of column both are same
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
