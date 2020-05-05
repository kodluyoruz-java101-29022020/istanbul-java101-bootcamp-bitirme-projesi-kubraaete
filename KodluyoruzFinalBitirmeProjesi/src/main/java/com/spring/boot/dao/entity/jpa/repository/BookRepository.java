package com.spring.boot.dao.entity.jpa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.boot.annotation.RunTime;
import com.spring.boot.dao.entity.Author;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.model.BookProfile;



@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	@RunTime(active = true)
	@Query(value = "FROM Book b WHERE b.bkNo = :bkNo")
	public Book findWithBkNo(@Param("bkNo") Long bkNo);
	
	@RunTime(active = true)
	@Query(value = "FROM Book b WHERE b.name = :name")
	public Book findWithName(@Param("name") String name);
	
	@RunTime(active = true)
	@Query(value = "SELECT MAX(b.bkNo) FROM Book b")
	public Long findMaxId();

	@RunTime(active = true)
	@Query(value = "SELECT b FROM Book b")
	public List<Book> getAllBookList();
	
	@RunTime(active = true)
	@Query(value = "SELECT new com.spring.boot.service.model.BookProfile(b, bAut.name) FROM Book b LEFT OUTER JOIN b.authors bAut where b.name = :name")
	public List<BookProfile> getAllBookProfileList(@Param("name") String name);
	
	@RunTime(active = true)
	@Query(value = "SELECT a FROM Author a")
	public List<Author> getAllAuthorList();
	
	
}
