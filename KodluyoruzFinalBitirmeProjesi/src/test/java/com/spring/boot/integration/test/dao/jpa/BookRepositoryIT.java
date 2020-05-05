package com.spring.boot.integration.test.dao.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.entity.Book;
import com.spring.boot.dao.entity.jpa.repository.BookRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Order(1)
	public void selectBookByBkNo() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBkNo(maxId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBkNo() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(2)
	public void saveEmployee() {
		
		Long maxId = bookRepository.findMaxId();
		Long newBookId = maxId + 1;
		
		Book book = new Book();
		book.setBkNo(newBookId);
		book.setName("Ahmet");
		book.setAuthor("Mehmet");
		book.setDescription("Açıklama");
		book.setNote("Not");
		book.setPrintingYear(1009L);
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBkNo(newBookId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBkNo() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(3)
	public void updateBook() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBkNo(maxId);
		
		book.setName("TestKitap");
		book.setAuthor("Ahmet");
		book.setNote("Kitap notu");
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBkNo(maxId);
		
		Assert.assertEquals("TestKitap", book.getName());
		Assert.assertEquals("Ahmet", book.getAuthor());
		Assert.assertEquals("Kitap Notu", book.getNote());
	}
	@Test
	@Transactional
	@Rollback(false)
	@Order(4)
	public void deleteBook() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBkNo(maxId);
		
		bookRepository.delete(book);
		
		book = bookRepository.findWithBkNo(maxId);
		
		Assert.assertNull(book);
	}

}

