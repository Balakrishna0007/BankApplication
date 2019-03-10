package com.cybrilla;

public class Swathi {

	public static void main(String[] args) {
	
		System.out.println("Hello World");
		
		Account swathi1=new Account();
		
		System.out.println("swathi1 details");
		System.out.println(swathi1.id);
		System.out.println(swathi1.name);
		System.out.println(swathi1.balance);
		
		Account swathi2 = new Account(102,"Sri",300);
		System.out.println("swathi2 details");
		System.out.println(swathi2.id);
		System.out.println(swathi2.name);
		System.out.println(swathi2.balance);
		
		CheckingAccount swathi3 = new CheckingAccount();
		System.out.println("swathi3 details");
		System.out.println(swathi3.id);
		System.out.println(swathi3.name);
		System.out.println(swathi3.balance);
	}

}
  class Account{
int id;
String name;
double balance;

Account()//default constructor
{
	id = 101;
	name = "Ram";
	balance = 200;
	
}
Account(int id1,String name1,double balance1)//constructor overloading
{
	id = id1;
	name = name1;
	balance = balance1;
}
}
  
  class CheckingAccount extends Account
  {
	 
  }

  