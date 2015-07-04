package edu.gatech.seclass.assignment8;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuggyClassBC3 {
	
	private BuggyClass buggyclass;
	@Before
	public void setUp() throws Exception {
		buggyclass = new BuggyClass();
	}

	@After
	public void tearDown() throws Exception {
		buggyclass = null;
	}
/* Test to achieve 100% Branch Coverage without revealing the fault*/
	@Test
	public void testmethod3a() 
	{ 
		assertEquals(6,buggyclass.method3("Value1",6));
	}
	
	@Test
	public void testmethod3b(){ 
		assertEquals(18,buggyclass.method3("Value2",-5));
	}	
	@Test
	public void testmethod3c(){ 
		assertEquals(7,buggyclass.method3("Value3",0));
	}	

}
