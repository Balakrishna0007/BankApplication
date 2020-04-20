package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.entity.BankCustomer;

public interface BankRepository extends CrudRepository<BankCustomer, Integer>
{
	
}
