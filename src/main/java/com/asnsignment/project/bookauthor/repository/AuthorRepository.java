package com.asnsignment.project.bookauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asnsignment.project.bookauthor.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
	//CRUD
	
}
