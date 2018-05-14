package mx.itesm.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E>{
	public Node<E> head;
	private int size;
	
	public LinkedList() {
		head = new Node<E>();
		size = 0;
	}
	
	@SafeVarargs
	public LinkedList(E... elements) {
		head = new Node<E>();
		size = 0;
		
		for (E element : elements) {
			addLast(element);
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public E get(int index) {
		return node(index).value;
	}
	
	/**
	 * Returns the value of the first element in the list
	 * @return the value of the first element in the list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
	    Node<E> p = head.next;
	    return p.value;
	}
	
	/**
	 * Returns the value of the last element in the list
	 * @return the value of the last element in the list
	 * @throws NoSuchElementExcption if this list is empty
	 */
	public E getLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<E> newNode= new Node<E>();
		newNode=head.next;
		while (newNode.next!= head){
				newNode=newNode.next;
		}
		return (newNode.value);
	}
	
	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> nodeToSet = node(index);
		E previousValue = nodeToSet.value;
		nodeToSet.value = element;
		
		return previousValue;
	}
	
	public void addFirst(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> previousFirst = head.next;
		
		head.next = newNode;
		newNode.next = previousFirst;
		previousFirst.prev = newNode;
		newNode.prev = head;
		
		size++;
	}
	
	public void addLast(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> previousLast = head.prev;
		
		previousLast.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		newNode.prev = previousLast;
		
		size++;
	}
	
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index == size()) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> nodeAtIndex = node(index);
			Node<E> previousNode = nodeAtIndex.prev;
			
			previousNode.next = newNode;
			newNode.next = nodeAtIndex;
			nodeAtIndex.prev = newNode;
			newNode.prev = previousNode;
			
			size++;
		}
	}
	
	/**
	 * Removes and returns the first element from this list.
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = head.next;
		Node<E> newFirst = nodeToRemove.next;
		
		head.next = newFirst;
		newFirst.prev = head;
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		
		size--;
		
		return nodeToRemove.value;
	}
	
	/**
	 * Removes and returns the last element from this list.
	 * @return the last element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = head.prev;
		Node<E> newLast = nodeToRemove.prev;
		
		newLast.next = head;
		head.prev = newLast;
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		
		size--;
		
		return nodeToRemove.value;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToDelete = node(index);
		Node<E> previousNode = nodeToDelete.prev;
		Node<E> nextNode = nodeToDelete.next;
		
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
		nodeToDelete.next = null;
		nodeToDelete.prev = null;
		
		size--;
		
		return nodeToDelete.value;
	}
	/**
	 * Gets the node at the specified index
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		
		Node<E> currentNode = null;
		
		if (index <= size / 2) {
			currentNode = head.next;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
		} else {
			currentNode = head.prev;
			for (int i = size - 1; i > index; i--) {
				currentNode = currentNode.prev;
			}
		}
		
		return currentNode;
	}
}