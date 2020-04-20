package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.BankCustomer;
import com.bank.exception.CustomerNotFoundException;
import com.bank.repository.BankRepository;

@Service
public class BankService 
{
	@Autowired
	private BankRepository repo;
	
	public BankCustomer createUser(final BankCustomer customer)
	{
		return repo.save(customer);
	}
	
	public BankCustomer fetchUserDetails(final int customerId)
	{
		if(repo.exists(customerId))
		{
			return repo.findOne(customerId);
		}
		throw new CustomerNotFoundException("Customer Details Not Found >>> "+customerId);
	}
	
	public BankCustomer deposit(final BankCustomer customer)
	{
		if(repo.exists(customer.getCustomerNumber()))
		{
			BankCustomer updateCustomer = repo.findOne(customer.getCustomerNumber());
			int newBalance = customer.getBalance() + updateCustomer.getBalance();
			updateCustomer.setBalance(newBalance);
			return repo.save(updateCustomer);
		}
		throw new CustomerNotFoundException("Deposit Not Possible for Not Existing Customer >>> "+customer.getCustomerNumber());
	}
	
	public BankCustomer withdrawl(final BankCustomer customer)
	{
		if(repo.exists(customer.getCustomerNumber()))
		{
			BankCustomer updateCustomer = repo.findOne(customer.getCustomerNumber());
			if(customer.getBalance() < updateCustomer.getBalance())
			{
				throw new CustomerNotFoundException("Balance is low "+customer.getCustomerNumber());
			}
			int newBalance = customer.getBalance() - updateCustomer.getBalance();
			updateCustomer.setBalance(newBalance);
			return repo.save(updateCustomer);
		}
		throw new CustomerNotFoundException("Deposit Not Possible for Not Existing Customer >>> "+customer.getCustomerNumber());
	}
	
	public BankCustomer updateBankDetails(final BankCustomer customer)
	{
		if (repo.exists(customer.getCustomerNumber())) 
		{
			BankCustomer updateCustomer = repo.findOne(customer.getCustomerNumber());
			updateCustomer.setBalance(customer.getBalance());
			return repo.save(updateCustomer);
		}
		throw new CustomerNotFoundException("Deposit Not Possible for Not Existing Customer >>> "+customer.getCustomerNumber());
	}

}
