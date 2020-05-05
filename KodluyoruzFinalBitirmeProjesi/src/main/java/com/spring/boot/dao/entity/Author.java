package com.spring.boot.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@Column(name = "aut_no", columnDefinition = "varchar(255)")
	private String autNo;
	
	@Column(name = "aut_name")
	private String name;
	
	//@JsonIgnore
	@ManyToMany(mappedBy = "departments", fetch = FetchType.LAZY)
	private List<Book> books;

	public String getAutNo() {
		return autNo;
	}

	public void setAutNo(String autNo) {
		this.autNo = autNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	

}
