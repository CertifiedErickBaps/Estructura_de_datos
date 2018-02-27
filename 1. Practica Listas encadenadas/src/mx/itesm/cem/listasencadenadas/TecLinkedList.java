package mx.itesm.cem.listasencadenadas;

import java.util.AbstractList;


// Practica 1: Listas Encadenadas
// Fecha: 02-Feb-2018
// Autores:
// A01379896 Erick Bautista Pérez
// A01378838 Eric Vazquez Gomez
// Comentarios: Implementacion de las clases size, get, set, add y remove con linked lists.

public class TecLinkedList<E> extends AbstractList<E>{
	private static class Node<E> {
		public E info;		//Generico cualquier clase
		public Node<E> next;
	
		public Node(E info, Node<E> next) {
			this.info = info;
			this.next = next;
		}
		public Node(E info) {
			this(info, null);	//Este manda a llamar a otro constuctor
		}
	}

	private Node<E> start = new Node<>(null);//Centinela
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public TecLinkedList(E... args) {
		for(E element: args) {
			add(element);
		}
	}
	
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> p = start.next;
		for(int i = 0; i< index; i++) {
			p = p.next;
		}
		return p.info;
	}
	
	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> p = start.next;
		for(int i = 0; i < index;i++) {
			p = p.next;
		}
		E resultado = p.info;
		p.info = element;
		return resultado;
	}
	
	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> afterNode = start;
		Node<E> newNode = new Node<>(element);
		for(int i = 0; i < index; i++) {
			afterNode = afterNode.next;
		}
		newNode.next = afterNode.next;
		afterNode.next = newNode;
		size++;
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index);
		}
		Node<E> aux = start;
		for(int i=-1; i<index-1; i++) {
			aux=aux.next;
		}
		Node<E> removed = aux.next;
		aux.next = aux.next.next;
		size--;
		return removed.info;
	}
	
}