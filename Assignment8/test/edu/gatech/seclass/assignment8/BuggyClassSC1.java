package edu.gatech.seclass.assignment8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuggyClassSC1 {

	private BuggyClass buggyclass;

	@Before
	public void setUp() throws Exception {
		buggyclass = new BuggyClass();
	}

	@After
	public void tearDown() throws Exception {
		buggyclass = null;
	}
/* Test achieves 100% Statement Coverage without revealing the fault*/
	@Test
	public void testmethod1() {		
		assertEquals(28, buggyclass.method1(4));
	}
	
}	