package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.LoginEntity;
import com.bank.repository.LoginRepository;

@Service
public class LoginService 
{
	@Autowired
	private LoginRepository repo;
	
	public boolean login(LoginEntity loginEntity)
	{
			for (LoginEntity entity : repo.findAll()) 
			{
				if(loginEntity.getUserName().equalsIgnoreCase(entity.getUserName()) && loginEntity.getPassword().equalsIgnoreCase(entity.getPassword()))
				{
					return true;
				}
			}
		return false;
	}

}
