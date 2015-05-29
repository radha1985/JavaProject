package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStringTest {

	private MyString mystring;

	@Before
	public void setUp() throws Exception {
		mystring = new MyString();
	}

	@After
	public void tearDown() throws Exception {
		mystring = null;
	}

	@Test
	public void testGetVowels1() {
		mystring.setString("This is my string. It includes three numbers: 1 2 3");
		assertEquals("iiiIiueeeue", mystring.getVowels());
	}

	@Test
	public void testGetVowels2() {
		mystring.setString("Second Test wITh   SpacEs");
		assertEquals("eoeIaE", mystring.getVowels());			
		
	}

	@Test
	public void testGetVowels3() 
	{
		mystring.setString("ThIrd Test with spEciAl CharaCTErs ?!@");
		assertEquals("IeiEiAaaE", mystring.getVowels());
	}
	
	@Test
	public void testNumberOfVowels1() {
		mystring.setString("yello");
		assertTrue(2 == mystring.numberOfVowels());
	}

	@Test
	public void testNumberOfVowels2() {
		mystring.setString("Second Test wITh   SpacEs and numbErs 871");
		assertEquals(9 , mystring.numberOfVowels()); 
	}

	@Test
	public void testNumberOfVowels3() {
		mystring.setString("ThIrd Test with spEciAl CharaCTErs ?!@");
		assertEquals(9 , mystring.numberOfVowels());		
	}
	@Test
	public void testGetCharacter1() {
		mystring.setString("This is my string. It includes three numbers: 1 2 3");
		assertTrue('n' == mystring.getCharacter(16));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCharacter2() {
		mystring.setString("Second Test to throw Illegal Argument Exception");		
		mystring.getCharacter(0);
	}

	
	@Test(expected = IllegalIndexException.class)
	public void testGetCharacter3() {
		mystring.setString("Third test to throw IllegalIndex Exception");		
		mystring.getCharacter(45);		
	}
	
	@Test(expected = IllegalIndexException.class)
	public void testFlipCaseInSubstring1() {
		mystring.setString("abcde");
		mystring.flipCaseInSubstring(1,7);
	}

	@Test
	public void testFlipCaseInSubstring2() {
		mystring.setString("SecoNd TeSt tO fliPPing String");
		mystring.flipCaseInSubstring(6, 10);		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFlipCaseInSubstring3() {
		mystring.setString("Third test to throw IllegalArgument Exception");
		mystring.flipCaseInSubstring(50, 10);		
	}
}