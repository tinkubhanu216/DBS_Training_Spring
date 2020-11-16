package com.rest_model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class User {
	@Id
	@PrimaryKeyJoinColumn
	String username;
	String password;
	
	public User() {}
	
	public User(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
