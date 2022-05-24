package com.asnsignment.project.bookauthor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asnsignment.project.bookauthor.model.LoginRequest;
import com.asnsignment.project.bookauthor.util.JwtUtility;

@RestController
public class UserValidatorController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtility utility;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public String generateToken(@RequestBody LoginRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Username and Password.");
		}

		return utility.generateToken(request.getUserName());
	}
}
