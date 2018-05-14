package mx.itesm.examenfinal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MiniArrayList<E> extends AbstractList<E> {
	
	/**
	 * Default initial capacity
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Array storage in which the elements of the ArrayList are stored.
	 * The capacity of the ArrayList is the length of this array.
	 */
	private E[] elements;
	
	/**
	 * The size of the ArrayList (the number of elements it contains).
	 */
	private int size;
	
	public MiniArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MiniArrayList(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("Illegal capacity");
		}
		
		elements = (E[])new Object[initialCapacity];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MiniArrayList(Collection<E> c) {
		Object[] collectionArray = c.toArray();
		size = collectionArray.length;
		elements = (E[]) Arrays.copyOf(collectionArray, size);
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return elements[index];
	}

	@Override
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int capacity() {
		return elements.length;
	}
	
	public Iterator<E> iterator() {
		return new MiniArrayListIterator();
	}
	
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
	
	/**
     * Trims the capacity of this ArrayList to be the
     * list's current size. Only trim if size() is greater than 0 and less than elements.length.
     * An application can use this operation to minimize the storage of an ArrayList instance.
     */
	public void trimToSize() {
		if(!isEmpty()) {
			size = capacity();
		}
	}
	
	/**
     * Increases the capacity of this ArrayList instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param   minCapacity   the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
    }
    
    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @throws NullPointerException if e is null
     * @return true
     */
    public boolean add(E e) {
    	return false;
    }
    
    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if index is out of bounds
     * @throws NullPointerException if element is null
     */
    public void add(int index, E element) {
    }
}