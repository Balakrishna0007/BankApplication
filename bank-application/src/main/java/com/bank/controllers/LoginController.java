package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.LoginEntity;
import com.bank.service.LoginService;

@RestController
public class LoginController 
{
	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginEntity loginEntity)
	{
		boolean isLoginSuccess = service.login(loginEntity);
		return new ResponseEntity<>(isLoginSuccess, HttpStatus.OK);
	}

}
