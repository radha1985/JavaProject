package edu.gatech.seclass;
import java.util.Scanner;

public class MyString implements MyStringInterface 
{	
	private String str;
	
	public void setString(String str)
	{
		this.str=str;
	}
	
	public String getString()
	{
		return str;
	}
	
	public String getVowels()
	{	
		String vowels = "aeiouAEIOU"; 
		String res=""; 
		for( int i = 0; i < str.length(); i++ ) 
		if( vowels.indexOf( str.charAt( i ) ) != -1 )	
			res=res+str.charAt( i );	    
		return(res);
	}
	
	public int numberOfVowels()
	{
		String vowels = "aeiouAEIOU"; 
		String res=""; 
		for( int i = 0; i < str.length(); i++ ) 
		if( vowels.indexOf( str.charAt( i ) ) != -1 )	
			res=res+str.charAt( i );
	    return(res.length());
	}
	
	public char getCharacter(int position) throws IllegalArgumentException,IllegalIndexException
	{	
		if(position>str.length())	
		{
			System.out.println("\n!!! Position is greater than length of the String Invalid!!!!");
			throw new IllegalIndexException();
		}		
		
		if(position <=0 )	
		{
			System.out.println();
			throw new IllegalArgumentException("\n!!! Position is invalid.Must be greater than 0 !!!!");
		}
		
		return(str.charAt(position-1));
			
	}
	
	public void flipCaseInSubstring(int startPosition, int endPosition) throws IllegalArgumentException,IllegalIndexException
	{
		
		if(endPosition>str.length())
		{
			System.out.println("\n!!! End Position is greater than length of the string Invalid!!!!");
			throw new IllegalIndexException();
		}
	
		if(startPosition <= 0 || endPosition <= 0 ||startPosition > endPosition)
		{
			System.out.println();		
			throw new IllegalArgumentException("\n!!! Position is invalid.Must be greater than 0");
		}
		
		String t = "";
        for (int x = startPosition - 1; x < endPosition; x++)
        {  
            char c = str.charAt(x);
            boolean check = Character.isUpperCase(c);
            if (check == true)
                t = t + Character.toLowerCase(c);
            else
                t = t + Character.toUpperCase(c);
        }
        
        System.out.printf ("\nFlip Case In SubString is : %s",t);
	}		
}
