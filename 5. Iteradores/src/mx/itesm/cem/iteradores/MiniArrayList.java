package mx.itesm.cem.iteradores;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiniArrayList<E> implements Iterable<E> {
	private class MiniArrayListIterator implements Iterator<E>{

		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < MiniArrayList.this.elements.length;
			
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E resultado = elements[index];
			index++;
			return resultado;
		}
		
	}
	
	private E[] elements;
	
	@SafeVarargs
	public MiniArrayList(E...args) {
		elements = args;
	}
	
	E get(int index) {
		if(index  < 0 || index >= elements.length) {
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}
	
	int size() {
		return elements.length;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MiniArrayListIterator();
	}
	
	public static void main(String[] args) {
		MiniArrayList<Integer> a = new MiniArrayList<>(4, 8, 15, 16, 23, 42);
		for(Integer elemento: a) {
			System.out.println(elemento);
		}
	}
	
}
