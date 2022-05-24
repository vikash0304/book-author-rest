package com.asnsignment.project.bookauthor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asnsignment.project.bookauthor.model.AuthorRequest;
import com.asnsignment.project.bookauthor.model.AuthorResponse;
import com.asnsignment.project.bookauthor.model.Response;
import com.asnsignment.project.bookauthor.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	/**
	 * API to Create author record
	 * 
	 * @param authorRequest
	 * @return
	 */
	@PostMapping(value = "/addAuthor", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> createAuthorRecord(@RequestBody AuthorRequest authorRequest) {
		Response response = authorService.createAuthorRecord(authorRequest);
		return new ResponseEntity<>(response.getMsg(), response.getStatus());
	}

	/**
	 * API to fetch details of an author by author-id
	 * 
	 * @param authorId
	 * @return
	 */
	@GetMapping(value = "/{authorId}")
	public ResponseEntity<AuthorResponse> fetchAuthorRecord(@PathVariable(name = "authorId") Integer authorId) {
		AuthorResponse response = authorService.fetchAuthorRecord(authorId);
		return response != null ? new ResponseEntity<>(response, HttpStatus.OK)
				: new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Fetching All authors
	 * 
	 * @return List<AuthorResponse>
	 */
	@GetMapping(value = "/all")
	public ResponseEntity<List<AuthorResponse>> fetchAllAuthorRecord() {
		List<AuthorResponse> listResponse = authorService.fetchAllAuthorRecord();
		return new ResponseEntity<>(listResponse, HttpStatus.OK);
	}

	/**
	 * API to Create author record
	 * 
	 * @param authorRequest
	 * @return
	 */
	@PutMapping(value = "/updateAuthor/{authorId}", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> updateAuthorRecord(@RequestBody AuthorRequest authorRequest,
			@PathVariable(name = "authorId") Integer authorId) {
		Response response = authorService.updateAuthorRecord(authorId, authorRequest);
		return new ResponseEntity<>(response.getMsg(), response.getStatus());
	}
	
	@DeleteMapping(value = "/{authorId}")
	public ResponseEntity<String> removeAuthorRecord(@PathVariable(name = "authorId") Integer authorId) {
		Response response = authorService.removeAuthorRecord(authorId);
		return new ResponseEntity<>(response.getMsg(), response.getStatus());
	}
}
