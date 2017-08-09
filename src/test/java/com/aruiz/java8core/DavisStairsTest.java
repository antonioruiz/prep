package com.aruiz.java8core;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DavisStairsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindPossibleways() {
		assertEquals(1,DavisStairs.findPossibleways(1));
		assertEquals(2,DavisStairs.findPossibleways(2));
		assertEquals(4,DavisStairs.findPossibleways(3));
		//assertEquals(7,DavisStairs.findPossibleways(4));
		//assertEquals(13, DavisStairs.findPossibleways(5));
	}
	
	@Test
	public void breakIntoLargestPossibleComponents(){
		Map<Integer, Integer> calculated = DavisStairs.breakIntoLargestPossibleComponents(5, 3);
		//break 5 into (3,2), that is 1 three, 1 Two a 0 ones
		assertEquals(3,calculated.size());
		assertEquals(1, calculated.get(3).intValue());
		assertEquals(1, calculated.get(2).intValue());
		assertEquals(0, calculated.get(1).intValue());
		assertEquals(new Integer(1),calculated.get(3));
		assertEquals(5, 3*calculated.get(3) 
				+ 2*calculated.get(2).intValue()
				+ 1*calculated.get(1).intValue());
		
		calculated = DavisStairs.breakIntoLargestPossibleComponents(7, 3);
		//break 7 into (3,3,1), that is 1 three, 1 Two a 0 ones
		assertEquals(3,calculated.size());
		assertEquals(calculated.get(3).intValue(), 2);
		assertEquals(calculated.get(2).intValue(), 0);
		assertEquals(calculated.get(1).intValue(), 1);
		assertEquals(7, 3*calculated.get(3) 
				+ 2*calculated.get(2).intValue()
				+ 1*calculated.get(1).intValue());

	}
}
