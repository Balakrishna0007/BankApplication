package com.cybrilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybrilla.entity.LoginEntity;
import com.cybrilla.repository.LoginRepository;

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
