package com.rest_model;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
	static ArrayList<Book> books=new ArrayList<Book>();
	
	public void addBook(int book_id,String book_name,String author_name){
		books.add(new Book(book_id,book_name,author_name));
	}
	public void deleteBook(int book_id) {
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
		    Book boo = itr.next();
		    if (boo.getBook_id()==book_id) {
		       itr.remove();
		    }
		}
	}
	public void updateBook(int book_id,String book_name,String author_name) {
		for( Book a : books) { 
			if (a.getBook_id()==book_id) {
				a.setBook_name(book_name);
				a.setAuthor_name(author_name);
			}
		}
		
	}
	public Book display(int book_id) {
		return null ;
	}
	public ArrayList<Book> displayAll() {
		return books;
	}
}
