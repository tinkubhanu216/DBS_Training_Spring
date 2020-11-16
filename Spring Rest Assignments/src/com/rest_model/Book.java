package com.rest_model;

public class Book {
	int book_id;
	String book_name;
	String author_name;
	Book(int book_id,String book_name,String author_name){
		this.book_id=book_id;
		this.book_name=book_name;
		this.author_name=author_name;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id=book_id;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name=book_name;
	}
	
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name=author_name;
	}
	public String toString() {
		return "Book Id:"+book_id+"Book Name:"+book_name+"Author Name"+author_name;
	}
}
