package mx.itesm.cem.filas;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListQueue<E> extends java.util.AbstractQueue<E>{
	/*----------------------------------------------------------
	 * Práctica 5: Fila genérica
	 * Fecha: 15-Mar-2018
	 * Autores:
	 *          A01379896 Erick Bautista Pérez
	 *	 		A01378838 Eric Vazquez Gomez
	 *----------------------------------------------------------*/
	
	private static class Node<E> {
		public E info = null;
		public Node<E> next = null;
		public Node<E> prev = null;
		
	}
	
	private class LinkedListSetIterator implements Iterator<E>{
		
		private Node<E> current = sentinel;
		@Override
		public boolean hasNext() {
			return current.next != sentinel;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			current = current.next;
			return current.info;
		}
	}
	
	private int size = 0;
	private Node<E> sentinel;
	
	public LinkedListQueue() {
		sentinel = new Node<>();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	
	public LinkedListQueue(Collection<E> coll) {
//		sentinel = new Node<>();
//		sentinel.next = sentinel;
//		sentinel.prev = sentinel;
//		for(E element : coll) {
//			offer(element);
//		}
		this();
		addAll(coll);
	}
		
	@Override
	public boolean offer(E info) {
		if(info.equals(null)) throw new NullPointerException();
		
		Node<E> newNode = new Node<>();
		newNode.info = info;
		newNode.next = sentinel;
		newNode.prev = sentinel.prev;
		sentinel.prev.next = newNode;
		sentinel.prev = newNode;
		size++;
		return true;
		
	}

	@Override
	public E peek() {
		return sentinel.next.info;
	}

	@Override
	public E poll() {
		if(isEmpty()) return null;
		E remove = sentinel.next.info;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return remove;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListSetIterator();
	}

	@Override
	public int size() {
		return size;
	}

}
