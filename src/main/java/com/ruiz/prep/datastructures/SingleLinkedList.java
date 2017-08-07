package com.ruiz.prep.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> extends AbstractSequentialList<E> {

	Node<E> head;
	int size;

	public SingleLinkedList() {
		head = null;
		size = 0;
	}

	public SingleLinkedList(Collection<? extends E> c) {
		this();
		if (c == null) {
			throw new NullPointerException("collection is null");
		}
		for (E e : c) {
			this.add(e);
		}
	}

	@Override
	public boolean add(E value) {
		// empty list
		if (head == null) {
			head = new Node<E>(value);
			size = 1;
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(value);
			size++;
		}
		return true;
	}
	
	@Override
	public void add(int index, E value) {
		if(index< 0 || index> size()){
			throw new IndexOutOfBoundsException();
		}
		if(index==size()){
			//end of list
			add(value);
			return;
		}
		Node<E> newNode = new Node<E>(value);
		if(index == 0){
			//beginning of list
			newNode.next = head;
			head = newNode;
			size++;
			return;
		}
		//position cursor to place of insertion
		Node<E> previousToCurrent = getNodeAt(index-1);
		newNode.next = previousToCurrent.next;
		previousToCurrent.next = newNode;
		size++;
	}
	
	public E get(int index){
		if(size()==0){
			throw new NoSuchElementException("list is empty");
		}
		if(index<0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return getNodeAt(index).data;
	}

	public void remove(E value) {
		// TODO Auto-generated method stub

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public E remove(int index) {
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

	private Node<E> getNodeAt(int index) {
		Node<E> current = head;
		int i=0;
		while(i < index){
			current = current.next;
			i++;
		}
		return current;
	}
}
