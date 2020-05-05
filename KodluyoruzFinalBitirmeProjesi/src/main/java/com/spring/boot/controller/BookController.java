package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.entity.Author;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.BookService;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;

@RestController
@RequestMapping("/archive")
public class BookController {
	@Autowired
	public BookService bookService;
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByBkNo(@PathVariable("id") Long id) {
		
		return bookService.findByBkNo(id);
	}
	
	@RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
	public Book findByName(@PathVariable("name") String name) {
		
		return bookService.findByName(name);
	}
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Book> getAllBookList() {
		
		return bookService.getAllBookList();
	}
	
	@RequestMapping(value = "/book/profile/list", method = RequestMethod.GET)
    public List<BookProfile> getAllBookProfileList(@PathVariable("name") String name) {
	
	List<BookProfile> profiles = bookService.getAllBookProfileList(name);
	
	return profiles;
}

	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody BookContext bookContext) {
		
		return bookService.save(bookContext);
	}
	
	@RequestMapping(value = "/book/author/list", method = RequestMethod.GET)
	public List<Author> getAllAuthorList() {
		
		return bookService.getAllAuthorList();
	}
	

}
