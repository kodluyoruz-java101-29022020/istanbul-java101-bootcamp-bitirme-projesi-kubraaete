package com.spring.boot.mock.test.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.boot.dao.entity.Book;
import com.spring.boot.dao.entity.jpa.repository.BookRepository;
import com.spring.boot.service.BookService;
import com.spring.boot.service.model.BookContext;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceMT {
	
	@Mock
    private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void queryBook() {
		
		Book bk = new Book();
	    bk.setBkNo(10L);
	    bk.setName("TestKitapAdı");
	    bk.setAuthor("TestKitapYazar");
	    bk.setDescription("TestKitapAçıklama");
	    bk.setNote("TestKitapNot");
	    bk.setPrintingYear(1099L);
	    
		Book bk1 = new Book();
	    bk.setBkNo(11L);
	    bk.setName("TestKitapAdı1");
	    bk.setAuthor("TestKitapYazar1");
	    bk.setDescription("TestKitapAçıklama1");
	    bk.setNote("TestKitapNot1");
	    bk.setPrintingYear(1999L);
	    
	    Mockito
	    	.when(bookRepository.findWithBkNo(10L))
	    	.thenReturn(bk);
	    
	    Mockito
	    	.when(bookRepository.findWithBkNo(11L))
	    	.thenReturn(bk1);
	    
		
		Book bk3 = bookService.findByBkNo(11L);
		
		Assert.assertNotNull(bk3);
		Assert.assertTrue(bk3.getBkNo() > 0);
	}
	
	@Test
	public void queryAllBooks() {
		
		
		Book bk = new Book();
	    bk.setBkNo(10L);
	    bk.setName("TestKitapAdı");
	    bk.setAuthor("TestKitapYazar");
	    bk.setDescription("TestKitapAçıklama");
	    bk.setNote("TestKitapNot");
	    bk.setPrintingYear(1099L);
	    
		
		Book bk1 = new Book();
	    bk.setBkNo(10L);
	    bk.setName("TestKitapAdı");
	    bk.setAuthor("TestKitapYazar");
	    bk.setDescription("TestKitapAçıklama");
	    bk.setNote("TestKitapNot");
	    bk.setPrintingYear(1099L);
	    
	    
		List<Book> books = Arrays.asList(bk, bk1);
		
		Mockito
			.when(bookRepository.getAllBookList())
			.thenReturn(books);
		
		
		
		List<Book> books2 = bookService.getAllBookList();
		
		Assert.assertNotNull(books2);
		Assert.assertTrue(books2.size() > 0);
	}
	
	@Test
	public void saveBook() {
		
		BookContext bkContext = new BookContext();
		bkContext.setName("KitapAdi");
		bkContext.setAuthor("Leyla");
		bkContext.setDescription("Kitap Açıklaması");
		bkContext.setNote("Kitap Notu");
		bkContext.setPrintingYear(1390L);
		
	    Long maxBookId = 100L;
	    
		Book bk = new Book();
		bk.setBkNo(maxBookId + 1);
		bk.setName(bkContext.getName());
		bk.setAuthor(bkContext.getAuthor());
		bk.setDescription(bkContext.getDescription());
		bk.setNote(bkContext.getNote());
		bk.setPrintingYear(bkContext.getPrintingYear());
		
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(maxBookId);
	    
		Mockito
			.when(bookRepository.save(bk))
			.thenReturn(bk);
		
		
		long bkId = bookService.save(bkContext);
		
		Assert.assertEquals(101L, bkId);
	}
	
	private void prepareMockTestRuleBookProfiles() {
	    
		Book bk1 = new Book();
	    bk1.setBkNo(10L);
	    bk1.setName("TestKitapAdı");
	    bk1.setAuthor("TestKitapYazar");
	    bk1.setDescription("TestKitapAçıklama");
	    bk1.setNote("TestKitapNot");
	    bk1.setPrintingYear(1999L);

		Book bk2 = new Book();
	    bk2.setBkNo(10L);
	    bk2.setName("TestKitapAdı");
	    bk2.setAuthor("TestKitapYazar");
	    bk2.setDescription("TestKitapAçıklama");
	    bk2.setNote("TestKitapNot");
	    bk2.setPrintingYear(1999L);
	    
	    
		List<Book> books = Arrays.asList(bk1, bk2);
		
		Mockito
			.when(bookRepository.getAllBookList())
			.thenReturn(books);
		
	}
	
	private void prepareMockTestRuleBookSave(BookContext bkContext) {
		
		Long bookId = 100L;
	    
		Book bk = new Book();
		bk.setBkNo(bookId + 1);
		bk.setName(bkContext.getName());
		bk.setAuthor(bkContext.getAuthor());
		bk.setDescription(bkContext.getDescription());
		bk.setNote(bkContext.getNote());
		bk.setPrintingYear(bkContext.getPrintingYear());
		
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(bookId);
	    
		Mockito
			.when(bookRepository.save(bk))
			.thenReturn(bk);
	}

}
