package mx.itesm.cem.pilas;

import java.util.NoSuchElementException;
/*----------------------------------------------------------
 * Practica 2: Pila de enteros
 * Fecha: 09-Feb-2018
 * Autores:
 *           A01379896 Erick Bautista Perez
 *           A01378839 Eric Gomez Vazquez
 *----------------------------------------------------------*/

public class IntStack {
	private int maxCapacity;
	private int maxIndex;
	private Integer[] data;
	private int size;
	
	public IntStack(int max) {	
		data = new Integer[max];
		maxCapacity = max;
		maxIndex = max - 1; //Se inicia con el indice maximo 
	}
	
	public void push(int x) {
		if (maxCapacity == size()) {
			throw new IllegalStateException("Stack Overflow");
		}
		data[maxIndex] = x;
		maxIndex--;
		size++;
	}
	
	public int pop() {
		int val;
		if (isEmpty()) {
			throw new NoSuchElementException("Stack Underflow");
		}else {
			val = data[maxIndex + 1];
			data[maxIndex + 1] = null;
			maxIndex++;
			size--;
		}
		return val;
	}

	public int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack Underflow");
		}
		return data[maxIndex+1];
	}
	
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size;
	}
	
}
