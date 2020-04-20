package com.cybrilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cybrilla.entity.LoginEntity;
import com.cybrilla.repository.LoginRepository;

@SpringBootApplication
public class BankApplication implements CommandLineRunner
{
	@Autowired
	private LoginRepository loginRepo;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		LoginEntity admin = new LoginEntity();
		admin.setUserName("admin");
		admin.setPassword("admin");
		loginRepo.save(admin);
		LoginEntity basicUser = new LoginEntity();
		basicUser.setUserName("guna");
		basicUser.setPassword("sekhar");
		loginRepo.save(basicUser);
	}
}

