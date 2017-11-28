package com.aruiz.prep.datastructures;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import java.util.Iterator;

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
	
	
	@Test
	public void testRemoveE() {
		createNonEmptyList();
		assertThat(l.size(), is(3));
		l.clear();
		assertNotNull(l);
		assertThat(l.size(), is(0));
	}
	
	@Test
	public void testSizeOfEmptyList() {
		createEmptyList();
		assertThat(l.size(), is(0));
	}
	
	@Test
	public void testSizeOfNonEmptyList() {
		createNonEmptyList();
		assertThat(l.size(), is(3));
	}
	
	@Test(expected = NullPointerException.class)
	public void testSizeOfNullList() {
		assertThat(l.size(), is(3));
	}
	
	@Test
	public void testIsEmpty() {
		createNonEmptyList();
		assertThat(l.isEmpty(), is(false));
	}
	@Test
	public void testIsEmptyForEmptyList() {
		createEmptyList();
		assertThat(l.isEmpty(), is(true));
	}
	
	@Test
	public void testContains() {
		createEmptyList();
		assertThat(l.size(), is(0));
		l.add("a");
		l.add("b");
		l.add("test text");
		assertThat(l.size(), is(3));
		l.add("e");
		assertThat(l.size(), is(4));
		assertThat(l.contains("e"), is(true));
		assertThat(l.contains("test"), is(false));
		assertThat(l.contains("a"), is(true));
		assertThat(l.contains("test text"), is(true));
	}
	@Test
	public void testContainsNull() {
		createEmptyList();
		assertThat(l.size(), is(0));
		l.add("l");
		l.add("m");
		l.add("test text");
		l.add(null);
		assertThat(l.size(), is(4));
		l.add("n");
		assertThat(l.contains("n"), is(true));
		assertThat(l.contains("test"), is(false));
		assertThat(l.contains("l"), is(true));
		assertThat(l.contains("test text"), is(true));
		assertThat(l.contains(null), is(true));
		
	}

	@Test
	public void testClear() {
		createNonEmptyList();
		assertThat(l.size(), is(3));
		l.clear();
		assertThat(l.size(), is(0));
	}

	@Test(expected=NoSuchElementException.class)
	public void testIterator() {
		createNonEmptyList();
		assertThat(l.size(), is(3));
		Iterator<String> it = l.iterator();
		assertThat(it, instanceOf(Iterator.class));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is("b"));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is("d"));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is("e"));
		assertFalse(it.hasNext());
		assertNull(it.next());
		fail("should not make it this far...");
	}
	@Test
	public void testIteratorOfEmptyList() {
		createEmptyList();
		assertThat(l.iterator().hasNext(), is(false));
	}
	

	@Test
	public void testRemoveInt() {
		createNonEmptyList();
		assertThat(l.size(), is(3));
		assertThat(l.contains("b"), is(true));
		assertThat(l.contains("d"), is(true));
		assertThat(l.contains("e"), is(true));
		l.remove(0);
		System.out.println("list: " + l);
		assertThat(l.size(), is(2));
		assertThat(l.contains("b"), is(false));
		l.remove(1);
		System.out.println("list: " + l);
		assertThat(l.size(), is(1));
		assertThat(l.contains("e"), is(false));
		l.remove(0);
		System.out.println("list: " + l);
		assertThat(l.size(), is(0));
		assertThat(l.contains("d"), is(false));
		l.add("a");
		l.add("b");
		l.add("c");
		assertThat(l.size(), is(3));
		l.remove(2);
		System.out.println("list: " + l);
		assertThat(l.size(), is(2));
		assertThat(l.contains("c"), is(false));
		
		
	}
/*
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
