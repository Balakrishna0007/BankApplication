package com.cybrilla.repository;

import org.springframework.data.repository.CrudRepository;

import com.cybrilla.entity.LoginEntity;

public interface LoginRepository extends CrudRepository<LoginEntity, Integer>
{
	
}
