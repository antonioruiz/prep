package com.ruiz.prep.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ruiz.prep.datastructures.model.Node;

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

	/**
	 * addd element value at the end of the list
	 */
	@Override
	public boolean add(E value) {
		// empty list
		if (head == null) {
			head = new Node<E>(value);
			size = 1;
		} else {
			Node<E> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<E>(value));
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
			newNode.setNext(head);
			head = newNode;
			size++;
			return;
		}
		//position cursor to place of insertion
		Node<E> previousToCurrent = getNodeAt(index-1);
		newNode.setNext(previousToCurrent.getNext() );
		previousToCurrent.setNext(newNode);
		size++;
	}
	
	public E get(int index){
		if(size()==0){
			throw new NoSuchElementException("list is empty");
		}
		if(index<0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return getNodeAt(index).getData();
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
		if(size==0) {
			return false;
		}
		
		Class<E> type = null;
		Node<E> current;
		boolean result = false;
		for(current= head;current!=null;current=current.getNext()) {
			E e = current.getData();
			if(e==null) { 
				if(o==null) {
					result=true;
					break;
				}else {
					continue;
				}
			}
			if(e.equals(o)) {
				result = true;
				break;
			}
		}
		
		return result;
	}

	public void clear() {
		head = null;
		size =0;
	}

	public Iterator<E> iterator() {

		Iterator<E> it = new Iterator<E>() {
			Node<E> currentNode = head;
			Node<E> previousNode = null;
			E currentValue = null;
			public boolean hasNext() {
				if(size==0) {
					return false;
				}
				boolean result = (currentNode !=null && currentNode.getData()!=null); 
				return result;
			}
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				E currentValue = currentNode.getData();
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				return currentValue;
			}
			public void remove() {
				if(previousNode == head) {
					head= previousNode.getNext();
					//current = head;
					previousNode = null;
					size--;
					return;
				}
				//now previous is next to the node we want to remove
				Node<E> tmp = head;
				while(tmp.getNext()!= previousNode) {
					tmp = tmp.getNext();
				}
				previousNode = tmp;
				previousNode.setNext(currentNode);
				size--;
				tmp = null;
				return;
				
			}
		};
		return it;
	}

	public E remove(int index) {
		
		E result = null;
		if(index>=size || index<0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> temp = getNodeAt(index);
		Iterator<E> it = iterator();
		while(it.hasNext()) {
			E e = it.next();
			if(e.equals(temp.getData())) {
				result = e;
				it.remove();
				break;
			}
		}
		
		return result;
	}

	public Object[] toArray() {
		return null;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	private Node<E> getNodeAt(int index) {
		Node<E> current = head;
		int i=0;
		while(i < index){
			current = current.getNext();
			i++;
		}
		return current;
	}

	@Override
	public String toString() {
		E e = null;
		StringBuilder sb = new StringBuilder();
		Iterator<E> it = iterator();
		while(it.hasNext()) {
			sb.append(it.next());
			sb.append(", ");
		}
		sb =sb.length()>0?sb.deleteCharAt(sb.length()-2):sb;
		String temp = "["+sb.toString().trim()+"]";
		
		return temp;
	}
	
}
