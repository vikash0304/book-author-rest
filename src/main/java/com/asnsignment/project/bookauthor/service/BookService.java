package com.asnsignment.project.bookauthor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asnsignment.project.bookauthor.entity.Book;
import com.asnsignment.project.bookauthor.model.BookResponse;
import com.asnsignment.project.bookauthor.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<BookResponse> getBookByAuthorName(String author) {
		List<BookResponse> books = new ArrayList<BookResponse>();
		List<Book> bookList = bookRepository.findBookByAuthor(author);
		bookList.forEach(b-> {
		BookResponse response = new BookResponse();
		response.setId(b.getId());
		response.setAuthor(b.getAuthor());
		response.setTitle(b.getTitle());
		books.add(response);
		});
		return books;
	}
}
