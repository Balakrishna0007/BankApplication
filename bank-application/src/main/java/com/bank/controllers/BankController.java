package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.BankCustomer;
import com.bank.service.BankService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BankController 
{
	
	@Autowired
	BankService service;
	
	@PostMapping("/registercustomerID")
	public BankCustomer addCustomer(@RequestBody BankCustomer customer)
	{
		//This is charan changes
		//This is 2nd commit changes
		//This 3rd commit
		BankCustomer cus = service.createUser(customer);
		return cus;
	}
	
	@GetMapping("/getdetails")
	public ResponseEntity<Object> getCustomerDetails(@RequestParam int customerId)
	{
		ResponseEntity<Object> response = null;
		try
		{
			BankCustomer customer = service.fetchUserDetails(customerId);
			response = new ResponseEntity<>(customer, HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			response = new ResponseEntity<>("Not Found "+customerId, HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PutMapping("/deposit")
	public BankCustomer deposit(@RequestBody BankCustomer customer)
	{
		return service.deposit(customer);
	}
	
	@PutMapping("/withdrawl")
	public BankCustomer withdrawl(@RequestBody BankCustomer customer)
	{
		return service.withdrawl(customer);
	}
	
	@PutMapping("/updateCustomerDetails")
	public BankCustomer updateBankAccountTypeDetails(@RequestBody BankCustomer customer)
	{
		return service.updateBankDetails(customer);
	}

}
