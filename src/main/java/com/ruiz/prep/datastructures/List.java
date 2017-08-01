package com.ruiz.prep.datastructures;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
	boolean add(E value);
	void add(int size, E value);
	void remove(E value);
	E get(int index);
	E set(int index,E element);
	int size();
	boolean isEmpty();
	boolean contains(Object o);
	void clear();
	Iterator<E> iterator();
	E remove(int index);
	Object[] toArray();
	<T> T[] toArray(T[] a);
}
