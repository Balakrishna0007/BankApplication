package com.cybrilla;

public class ABCD4 
{
  static  int i,j,k;
   
	public static void main(String[] args)
	{
		for (int i = 0; i < 6; i++) 
		{
            for (int j = 0; j < 5 - i; j++)
            {
                System.out.print(" ");
            }
            
            for (int k = 0; k <= i; k++)
            {
                System.out.print("# ");
                
            }
            System.out.println();	
	
	  }
		
	}
	
		
	
}
