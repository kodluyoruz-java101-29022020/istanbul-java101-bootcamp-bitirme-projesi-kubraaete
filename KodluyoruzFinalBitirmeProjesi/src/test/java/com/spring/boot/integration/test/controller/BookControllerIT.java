package com.spring.boot.integration.test.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.model.BookContext;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BookControllerIT {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int tomcatPortNo;
	
	@Test
	@Order(1)
	public void testRestTemplate() {
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		System.out.println(tomcatPortNo);
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}
	
	@Test
	@Order(2)
	public void findBookById() {
		
		String url = prepareEmployeeRestServiceRootUrl() + "book/10000";
		
		ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
		
		Book bk = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(10000 == bk.getBkNo());
	}
	
	@Test
	@Order(3)
	public void saveBook() {
		
		String url = prepareEmployeeRestServiceRootUrl() + "book";
		
		BookContext bookContext = new BookContext();
		bookContext.setName("TestUser1");
		bookContext.setAuthor("TestAuthor");
		bookContext.setDescription("TestDescription");
		bookContext.setNote("TestNote");
		bookContext.setPrintingYear(1000L);
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url, bookContext, Long.class);
		
		Long bkNo = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(bkNo);
	}
	
	private String prepareEmployeeRestServiceRootUrl() {
		
		return "http://localhost:" + tomcatPortNo + "/archive/";
	}


}
