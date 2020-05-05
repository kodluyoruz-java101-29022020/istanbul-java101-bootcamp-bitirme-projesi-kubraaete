package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.annotation.RunTime;
import com.spring.boot.dao.entity.Author;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.dao.entity.jpa.repository.BookRepository;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RunTime(active = true)
	public Book findByBkNo(Long bkNo) {
		
		return bookRepository.findWithBkNo(bkNo);
	}
	
	@RunTime(active = true)
	public Book findByName(String name) {
		return bookRepository.findWithName(name);
	}
	
	@RunTime(active = true)
	public List<Book> getAllBookList() {
		
		return bookRepository.getAllBookList();
	}
	
	@RunTime(active = true)
	public List<BookProfile> getAllBookProfileList(String name) {
		
		return bookRepository.getAllBookProfileList(name);
	}
	
	@RunTime(active = true)
	@Transactional
	public Long save(BookContext bookContext) {
		
		Long maxId = bookRepository.findMaxId() + 1;
		
		Book book = new Book();
		book.setBkNo(maxId);
		book.setName(bookContext.getName());
		book.setPrintingYear(bookContext.getPrintingYear());
		book.setDescription(bookContext.getDescription());
		book.setNote(bookContext.getAuthor());
		book.setAuthor(bookContext.getAuthor());
		
		book = bookRepository.save(book);
		
		
		return book.getBkNo();
	}
	
	@RunTime(active = true)
	public List<Author> getAllAuthorList() {
		
		return bookRepository.getAllAuthorList();
	}

}
