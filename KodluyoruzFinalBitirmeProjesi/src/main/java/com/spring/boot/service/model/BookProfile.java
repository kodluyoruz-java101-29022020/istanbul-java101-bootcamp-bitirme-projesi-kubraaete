package com.spring.boot.service.model;

import com.spring.boot.dao.entity.Book;

public class BookProfile {
	private Book book;
	private String authorName;
	
	public BookProfile() {}

	public BookProfile(Book book, String authorName) {
		this.book = book;
		this.authorName = authorName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

	
	
	

}
