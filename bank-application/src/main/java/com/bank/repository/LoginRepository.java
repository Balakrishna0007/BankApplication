package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.entity.LoginEntity;

public interface LoginRepository extends CrudRepository<LoginEntity, Integer>
{
	
}
