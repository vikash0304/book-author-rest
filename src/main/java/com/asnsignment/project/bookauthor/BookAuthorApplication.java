package com.asnsignment.project.bookauthor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asnsignment.project.bookauthor.entity.Author;
import com.asnsignment.project.bookauthor.entity.Book;
import com.asnsignment.project.bookauthor.entity.UserInfo;
import com.asnsignment.project.bookauthor.repository.AuthorRepository;
import com.asnsignment.project.bookauthor.repository.BookRepository;
import com.asnsignment.project.bookauthor.repository.UserInfoRepository;

@SpringBootApplication
public class BookAuthorApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookAuthorApplication.class, args);
	}

	@PostConstruct
	public void populateMockData() {

		// Populate Users
		List<UserInfo> users = Arrays.asList(new UserInfo(1, "vikash", "password1", "vikash1@gmail.com"),
				new UserInfo(2, "user2", "password2", "user2@gmail.com"),
				new UserInfo(3, "user3", "password3", "user3@gmail.com"),
				new UserInfo(4, "user4", "password4", "user4@gmail.com"));
		userInfoRepository.saveAll(users);

		// Populate Books
		Book book1 = new Book("java", "vikash");
		Book book2 = new Book("oracle", "user1");
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		bookRepository.saveAll(books);

		// Populate Author
		Author author1 = new Author("vikash", "java");
		Author author2 = new Author("user1", "oracle");
		List<Author> authors = new ArrayList<Author>();
		authors.add(author1);
		authors.add(author2);
		authorRepository.saveAll(authors);

	}
}
