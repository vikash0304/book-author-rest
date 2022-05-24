package com.asnsignment.project.bookauthor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asnsignment.project.bookauthor.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findBookByAuthor(String author);
}
