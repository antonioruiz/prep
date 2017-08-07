package com.ruiz.prep.datastructures;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractList<E> implements List<E> {
	
	public abstract E get(int index);
	
	public E set(int index, E element){
		throw new UnsupportedOperationException();
	}
	
	public boolean add(E value){
		add(size(), value);
		return true;
	}
	
	public void add(int index, E value){
		throw new UnsupportedOperationException();
	}

	public abstract void remove(E value);

	public abstract int size();

	public abstract boolean isEmpty();

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		AbstractSequentialList<E> a;
		ArrayList<E> al;
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
