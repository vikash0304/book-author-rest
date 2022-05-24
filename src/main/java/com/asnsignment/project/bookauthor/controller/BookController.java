package com.asnsignment.project.bookauthor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asnsignment.project.bookauthor.model.BookResponse;
import com.asnsignment.project.bookauthor.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/{author}")
	public List<BookResponse> getBookByAuthorName(@PathVariable(name="author") String author) {
		return bookService.getBookByAuthorName(author);
	}
}
