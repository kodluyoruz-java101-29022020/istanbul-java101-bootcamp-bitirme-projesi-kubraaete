package com.spring.boot.service.model;

import java.io.Serializable;


public class BookContext implements Serializable{

	private static final long serialVersionUID = -3546324347129770450L;

	private String name;
	private Long printingYear;
	private String description;
	private String author;
	private String note;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrintingYear() {
		return printingYear;
	}
	public void setPrintingYear(Long printingYear) {
		this.printingYear = printingYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
