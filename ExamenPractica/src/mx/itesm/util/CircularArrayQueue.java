package mx.itesm.util;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> extends AbstractQueue<E> {

	private class CircularArrayQueueIterator implements Iterator<E> {

		private int currentNode = front;
		private boolean firstTime = true;

		@Override
		public boolean hasNext() {
			return !isEmpty() && (currentNode != back || firstTime);
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = data[currentNode];
			currentNode = (currentNode + 1) % capacity;
			firstTime = false;
			return result;
		}

	}

	private static final int MAX_DEFAULT_CAPACITY = 10;
	private E[] data;
	private int size;
	private int capacity;
	private int front;
	private int back;

	public CircularArrayQueue() {
		this(MAX_DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.front = this.back = 0;
		this.data = (E[]) new Object[capacity];
	}

	private boolean isFull() {
		return size == capacity;
	}

	@Override
	public boolean offer(E element) {
		if (isFull()) {
			return false;
		}

		data[back] = element;
		back = (back + 1) % capacity;
		size++;
		return true;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return data[front];
	}

	@Override
	public E poll() {
		if (isEmpty()) {
			return null;
		}

		E copy = data[front];
		data[front] = null;
		front = (front + 1) % capacity;
		size--;
		return copy;
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
		CircularArrayQueue<Integer> q = new CircularArrayQueue<Integer>(6);
		q.offer(8);
		q.offer(15);
		System.out.println(q);
	}
}