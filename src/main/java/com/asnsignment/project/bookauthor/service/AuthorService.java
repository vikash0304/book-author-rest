package com.asnsignment.project.bookauthor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asnsignment.project.bookauthor.entity.Author;
import com.asnsignment.project.bookauthor.model.AuthorRequest;
import com.asnsignment.project.bookauthor.model.AuthorResponse;
import com.asnsignment.project.bookauthor.model.Response;
import com.asnsignment.project.bookauthor.repository.AuthorRepository;

/**
 * 
 * @author Vikash_Kumar2
 *
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	/**
	 * 
	 * @param authorRequest
	 * @return
	 */
	public Response createAuthorRecord(AuthorRequest authorRequest) {
		Response response;
		Author author = new Author();
		author.setBooks(authorRequest.getBook());
		author.setName(authorRequest.getName());
		try {
			authorRepository.save(author);
			response = new Response("Success", HttpStatus.CREATED);
		} catch (Exception e) {
			response = new Response("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * 
	 * @param authorId
	 * @return
	 */
	public AuthorResponse fetchAuthorRecord(Integer authorId) {
		AuthorResponse response = null;
		Optional<Author> author = authorRepository.findById(authorId);
		if (author.isPresent()) {
			response = new AuthorResponse();
			response.setId(authorId);
			response.setBook(author.get().getBook());
			response.setName(author.get().getName());
		} else {
			return response;
		}
		return response;
	}

	/**
	 * 
	 */
	public List<AuthorResponse> fetchAllAuthorRecord() {
		List<AuthorResponse> listAuthorResponse = new ArrayList<>();
		List<Author> listAuthor = authorRepository.findAll();
		listAuthor.stream().forEach(l -> {
			AuthorResponse authorResponse = new AuthorResponse();
			authorResponse.setId(l.getId());
			authorResponse.setBook(l.getBook());
			authorResponse.setName(l.getName());
			listAuthorResponse.add(authorResponse);
		});
		return listAuthorResponse;
	}

	public Response updateAuthorRecord(Integer authorId, AuthorRequest authorRequest) {
		Response response = null;
		try {
			Optional<Author> author = authorRepository.findById(authorId);
			if (author.isPresent()) {
				author.get().setBooks(authorRequest.getBook());
				author.get().setName(authorRequest.getName());
				authorRepository.save(author.get());
				response = new Response("Success", HttpStatus.OK);
			} else {
				response = new Response("Data Not Present for Update", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			response = new Response("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * 
	 * @param authorId
	 * @return
	 */
	public Response removeAuthorRecord(Integer authorId) {
		Response response = null;
		try {
			authorRepository.deleteById(authorId);
			response = new Response("Success", HttpStatus.OK);
		} catch (Exception e) {
			response = new Response("Data Not Present", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}