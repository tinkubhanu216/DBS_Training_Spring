package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@Column
	String username;
	@Column
	String password;
	
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
}
