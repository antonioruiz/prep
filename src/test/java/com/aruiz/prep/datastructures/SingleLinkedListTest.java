package com.aruiz.prep.datastructures;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.ruiz.prep.datastructures.SingleLinkedList;

public class SingleLinkedListTest {

	SingleLinkedList<String> l;

	
	
	private void createEmptyList() {
		l = new SingleLinkedList<String>();
	}

	private void createNonEmptyList() {
		l = new SingleLinkedList<String>();
		l.add("b");
		l.add("d");
		l.add("e");
	}
	
	
	@Test(expected = NullPointerException.class)
	public void getElementFromNullList() {
		l.get(0);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getElementFromEmptyList() {
		createEmptyList();
		String e = l.get(0);
		assertEquals(null, e);
	}
	
	@Test
	public void getElementsOfNonEmptyList(){
		createNonEmptyList();
		assertEquals(3, l.size());
		assertEquals("b", l.get(0));
		assertEquals("d", l.get(1));
		assertEquals("e", l.get(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getElementOutOfBoundsOfNonEmptyList(){
		createNonEmptyList();
		assertEquals(3, l.size());
		assertEquals("b", l.get(0));
		assertEquals("d", l.get(1));
		assertEquals("e", l.get(2));
		l.get(3);
	}
	

	@Test(expected = NullPointerException.class)
	public void addToNullList() {
		l.add("test");
		fail("Should not reach this point");
	}
	
	@Test(expected = NullPointerException.class)
	public void addAtIndexToNullList() {
		assertNull(l);
		l.add(0, "test");
		fail("Should not reach this point");
	}

	@Test
	public void addToNonNullEmptyListAtIndexZero() {
		assertNull(l);
		createEmptyList();
		assertNotNull(l);
		assertEquals(0, l.size());
		String newElement = "test";
		l.add(newElement);
		assertEquals(1, l.size());
		assertEquals(newElement, l.get(0));
	}
	
	@Test
	public void addToNonEmptyListAtIndexZero() {
		createNonEmptyList();
		assertNotNull(l);
		assertEquals(3, l.size());
		String newElement = "test element";
		l.add(0,newElement);
		assertEquals(4, l.size());
		assertEquals(newElement, l.get(0));
		//remainder elements should be shifted by one
		assertEquals("b", l.get(1));
		assertEquals("d", l.get(2));
		assertEquals("e", l.get(3));
	}
	
	@Test
	public void addToNonEmptyListAtEndOfList() {
		createNonEmptyList();
		assertNotNull(l);
		assertEquals(3, l.size());
		String newElement = "test element";
		l.add(l.size(),newElement);
		assertEquals(4, l.size());
		assertEquals(newElement, l.get(3));
		//remainder elements should remain equal
		assertEquals("b", l.get(0));
		assertEquals("d", l.get(1));
		assertEquals("e", l.get(2));
	}
	
	@Test
	public void addToNonEmptyListAtMiddleOfList() {
		createNonEmptyList();
		assertNotNull(l);
		assertEquals(3, l.size());
		String newElement = "test element";
		l.add(2,newElement);
		assertEquals(4, l.size());
		assertEquals(newElement, l.get(2));
		assertEquals("b", l.get(0));
		assertEquals("d", l.get(1));
		assertEquals(newElement,l.get(2));
		assertEquals("e", l.get(3));
	}
	
	/*
	@Test
	public void testRemoveE() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented");
	}
	*/


}
