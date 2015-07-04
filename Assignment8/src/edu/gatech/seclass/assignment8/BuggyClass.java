package edu.gatech.seclass.assignment8;

public class BuggyClass
{
	public int method1(int a)
	{	
	    String s = null;
				    
			if(!(a < 0))
				s = "Value of a is greater than 0";
			return(s.length());
	}
	
	public void method2()
	{	
		System.out.println("Such a Method cannot be created");
	}
	
	public int method3(String s1,int a) 
	{ 

		String s="Default"; 
		if ( a > 0 )
			s = s1;
		else if (a < 0)
			s = "in else path" + s1;
		return(s.length());
	}		
}
	
	 
	  

