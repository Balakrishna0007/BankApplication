package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.BankCustomer;
import com.bank.entity.Transaction;
import com.bank.exception.InSufficientFundsException;
import com.bank.repository.BankRepository;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionService 
{
	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private BankRepository bankRepo;
	
	public void doTransaction(final Transaction transaction)
	{
		if(bankRepo.exists(transaction.getFromAccountNumber()) && bankRepo.exists(transaction.getToAccountNumber()))
		{
			if(transaction.getAmount()>0)
			{
				if(validateAccountBalance(transaction.getFromAccountNumber(),transaction.getAmount()))
				{
					BankCustomer fromCustomer = bankRepo.findOne(transaction.getFromAccountNumber());
					BankCustomer toCustomer = bankRepo.findOne(transaction.getToAccountNumber());
					fromCustomer.setBalance(fromCustomer.getBalance()-transaction.getAmount());
					toCustomer.setBalance(toCustomer.getBalance()+transaction.getAmount());
					repo.save(transaction);
					bankRepo.save(fromCustomer);
					bankRepo.save(toCustomer);
				}
			}
		}
	}

	private boolean validateAccountBalance(final int fromAccountNumber,final int transAmount) 
	{
		BankCustomer fromCustomer = bankRepo.findOne(fromAccountNumber);
		if(transAmount > fromCustomer.getBalance())
		{
			throw new InSufficientFundsException("Insufficeint Balance .. Transaction Declined !!!!!!!!!!");
		}
		return Boolean.TRUE;
	}

}
