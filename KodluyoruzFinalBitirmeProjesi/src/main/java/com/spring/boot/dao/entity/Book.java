package com.spring.boot.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Book implements Serializable{

	private static final long serialVersionUID = 1968096988464316183L;
	
	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "bk_no")
	private Long bkNo;
	
	@Column(name = "book_name")
	private String name;
	
	@Column(name = "prn_year")
	private Long printingYear;

	@Column(name = "bk_desc")
	private String description;
	
	@Column(name = "bk_author")
	private String author;
	
	@Column(name = "bk_note")
	private String note;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "aut_bk",
			joinColumns = { @JoinColumn(name = "bk_no") },
			inverseJoinColumns =  { @JoinColumn(name = "aut_no") }
	)
	private List<Author> authors;
	
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Long getBkNo() {
		return bkNo;
	}

	public void setBkNo(Long bkNo) {
		this.bkNo = bkNo;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bkNo == null) ? 0 : bkNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((printingYear == null) ? 0 : printingYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bkNo == null) {
			if (other.bkNo != null)
				return false;
		} else if (!bkNo.equals(other.bkNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (printingYear == null) {
			if (other.printingYear != null)
				return false;
		} else if (!printingYear.equals(other.printingYear))
			return false;
		return true;
	}
	

}
