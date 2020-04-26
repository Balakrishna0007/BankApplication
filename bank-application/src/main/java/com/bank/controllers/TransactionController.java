package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Transaction;
import com.bank.service.TransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TransactionController 
{
	@Autowired
	private TransactionService service;
	
	@PostMapping("/doTransaction")
	public void transferAmount(@RequestBody Transaction transaction)
	{
		service.doTransaction(transaction);
	}

}
