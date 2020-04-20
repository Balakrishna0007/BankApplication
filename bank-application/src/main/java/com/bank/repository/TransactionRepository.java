package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{

}
