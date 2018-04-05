package mx.itesm.cem.filas;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;


public class CircularArrayQueue<E> extends AbstractQueue<E>{

	private class CircularArrayQueueIterator implements Iterator<E> {
		
		private int current = next;
		private boolean firstTime = true;
		
		@Override
		public boolean hasNext() {
			return !isEmpty() && (current != last || firstTime);
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			E result = data[current];
			current = (current + 1) % capacity;
			firstTime = false;
			return result;
		}
	}

	private static final int MAX_DEFAULT_CAPACITY = 10;
	private int size;
	private int capacity;
	private int next;
	private int last;
	private E[] data;
	
	
	public CircularArrayQueue() {
		this(MAX_DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.next = this.last = 0;
		this.data = (E[]) new Object[capacity];
	}	
	
	@Override
	public boolean offer(E element) {
		Objects.nonNull(element); // Arroja la excepcion
		if(isFull()) return false;
		data[last] = element;
		last = (last +1) % capacity;//Regresara last a 0 si el index es igual a su capacidad y la baja
		size++;
		return true;
	}

	private boolean isFull() {
		return size == capacity;
	}

	@Override
	public E peek() {
		if(isEmpty()) return null;
		return data[next];
	}

	@Override
	public E poll() {
		if(isEmpty()) return null;
		E result = data[next];
		data[next] = null;
		next = (next + 1) % capacity; //Verifica si esta en el ultimo valor de la fila
		size--;
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return new CircularArrayQueueIterator();
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		Queue<String> q = new CircularArrayQueue<>(5);
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.offer("d");
		System.out.println(q.size() + " " + q);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.size() + " " + q);
		q.offer("e");
		q.offer("f");
		q.offer("g");
		q.offer("h");
		q.offer("i");
		System.out.println(q.size()  + " " + q);
		
		
		
	}

}
