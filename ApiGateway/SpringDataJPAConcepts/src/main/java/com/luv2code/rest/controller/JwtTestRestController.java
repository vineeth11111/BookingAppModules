package com.luv2code.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.jwt.JwtManager;

@RestController
public class JwtTestRestController {
	
	@Autowired
	private JwtManager jwtManager;

	@GetMapping("/get/{userId}")
	public ResponseEntity<String> getToken(@PathVariable String userId)
	{
		return new ResponseEntity<String>(jwtManager.createToken(userId), HttpStatus.OK);
	}
	
	@PostMapping("/isValid/token/{userId}")
	public ResponseEntity<Boolean> isValidToken(@PathVariable String userId , @RequestHeader String token){
		boolean validToken = jwtManager.isValidToken(userId, token);
		return new ResponseEntity<Boolean>(validToken , HttpStatus.OK);
	}
}
