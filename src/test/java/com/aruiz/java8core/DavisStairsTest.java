package com.aruiz.java8core;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class DavisStairsTest {

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void testFindPossibleways() {
		assertEquals(1,DavisStairs.findPossibleways(1));
		assertEquals(2,DavisStairs.findPossibleways(2));
		assertEquals(4,DavisStairs.findPossibleways(3));
		//assertEquals(7,DavisStairs.findPossibleways(4));
		//assertEquals(13, DavisStairs.findPossibleways(5));
	}
	
	@Test
	public void breakIntoLargestPossibleComponents(){
		Map<Integer, Integer> calculated = DavisStairs.breakIntoLargestPossibleComponents(5);
		//break 5 into (3,2), that is 1 three, 1 Two a 0 ones
		assertEquals(2,calculated.size());
		assertEquals(1, calculated.get(3).intValue());
		assertEquals(1, calculated.get(2).intValue());
		assertEquals(new Integer(1),calculated.get(3));
		assertEquals(5, 3*calculated.get(3) 
				+ 2*calculated.get(2).intValue());
		
		calculated = DavisStairs.breakIntoLargestPossibleComponents(7);
		//break 7 into (3,3,1), that is 2 threes, 1 ones
		assertEquals(2,calculated.size());
		assertEquals(2, calculated.get(3).intValue());
		assertEquals(1, calculated.get(1).intValue());
		assertEquals(7, 3*calculated.get(3) 
				+ 1*calculated.get(1).intValue());

		calculated = DavisStairs.breakIntoLargestPossibleComponents(2);
		//break 2 into (0,0,2), that is 0 threes, 0 twos and  2 ones
		assertEquals(1,calculated.size());
		assertEquals(1,calculated.get(2).intValue());
		assertEquals(2,  2*calculated.get(2).intValue());

	}
	
	@Test
	public void breakIntoLargestPossibleComponentsBeginintWithN(){
		Map<Integer, Integer> calculated = DavisStairs.breakIntoLargestPossibleComponents(5,2);
		//break 5 into (2,3), that is 1 three, 1 Two
		assertEquals(2,calculated.size());
		assertEquals(1, calculated.get(3).intValue());
		assertEquals(1, calculated.get(2).intValue());
		assertEquals(new Integer(1),calculated.get(3));
		assertEquals(5, 3*calculated.get(3) 
				+ 2*calculated.get(2).intValue());
		
		calculated = DavisStairs.breakIntoLargestPossibleComponents(7,2);
		//break 7 into (2,3,2), that is 1 threes, 2 twos
		assertEquals(2,calculated.size());
		assertEquals(1, calculated.get(3).intValue());
		assertEquals(2, calculated.get(2).intValue());
		assertEquals(7, 3*calculated.get(3) 
				+ 2*calculated.get(2).intValue());

		calculated = DavisStairs.breakIntoLargestPossibleComponents(2,1);
		//break 2 into (0,0,2), that is 0 threes, 0 twos and  2 ones
		assertEquals(1,calculated.size());
		assertEquals(2,calculated.get(1).intValue());
		assertEquals(2,  1*calculated.get(1).intValue());
		
		calculated = DavisStairs.breakIntoLargestPossibleComponents(12,2);
		//break 2 into (3,2,1), that is 3 threes, 1 twos and 1 ones
		assertEquals(3,calculated.size());
		assertEquals(1,calculated.get(2).intValue());
		assertEquals(3,calculated.get(3).intValue());
		assertEquals(1,calculated.get(1).intValue());
		assertEquals(12,  1*calculated.get(1).intValue() +
				2*calculated.get(2) + 3*calculated.get(3));

	}
	@Test
	public void  calculateComponentsAsStrings(){
		Map<Integer, Integer> calculatedComponent = DavisStairs.breakIntoLargestPossibleComponents(8);
		//break 8 into (3,3,2), that is 2 threes, 1 two
		assertEquals(2,calculatedComponent.size());
		assertEquals(calculatedComponent.get(3).intValue(), 2);
		assertEquals(calculatedComponent.get(2).intValue(), 1);
		assertEquals(7, 3*calculatedComponent.get(3) 
				+ 1*calculatedComponent.get(2).intValue());

		
		String componentAsString= DavisStairs.calculateComponentsAsString(calculatedComponent);
		assertEquals("3+3+2", componentAsString);
	}
}
