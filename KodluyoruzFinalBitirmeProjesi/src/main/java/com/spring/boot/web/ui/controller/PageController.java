package com.spring.boot.web.ui.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.dao.entity.Author;
import com.spring.boot.service.BookService;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;
import com.spring.boot.dao.entity.Book;


@Controller
@RequestMapping("/pages")
public class PageController {
	@Autowired
	private BookService bookService;
	
	//Tüm liste geliyor.
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> books = bookService.getAllBookList();
		model.addAttribute("books", books);
		
		return "thyme_book_list";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {
		
		return "thyme_book_save";
	}
	//Eklenilen kayıt listeye eklenip ekrana geliyor.
	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(BookContext bookContext, BindingResult result, Model model) {
        
		
		bookService.save(bookContext);
        
		model.addAttribute("books", bookService.getAllBookList());
        
        return "thyme_book_list";
    }
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getAuthors(Model model) {
		
		List<Author> authors = bookService.getAllAuthorList();
		model.addAttribute("authors", authors);
		
		return "thyme_book_list";
	}
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBookSearch(String name, Model model) {
		
		List<BookProfile> profiles = bookService.getAllBookProfileList(name);
		model.addAttribute("profiles", profiles);
		
		return "thyme_book_list";
	}
	
	

}
