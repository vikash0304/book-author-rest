package com.asnsignment.project.bookauthor.model;

public class AuthorResponse {

	private Integer id;
	private String name;
	private String book;

	public AuthorResponse() {
		super();
	}

	public AuthorResponse(Integer id, String name, String book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

}
