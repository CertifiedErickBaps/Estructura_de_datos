package mx.itesm.cem.examen2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/*----------------------------------------------------------
 * Examen 2
 * Fecha: 15-Mar-2018
 * Autor:
 *          A01379896 Erick Bautista Pérez
 *          A013788838 Eric Gomez Vazquez
 *----------------------------------------------------------*/

public class IntArraySet extends java.util.AbstractSet<Integer>{
	public class IntArraySetIterator implements Iterator<Integer>{
		private int x = 0;
		private int result = 0;
		@Override
		public boolean hasNext() {
			boolean flag = false;
			for(int i = x; i < set.length; i++) {
				if(set[i]) flag = true;
			}
			return flag;
		}
		@Override
		public Integer next() {
			if(!hasNext()) throw new NoSuchElementException();
			while(!set[x]) {
				x++;
			}
			result = x;
			x++;
			return result;
		}			
	}
	
	private int size;
	private int n;
	private boolean[] set;	
	public IntArraySet(int n) {
		this.size = 0;
		this.n = n;
		set = new boolean[n];
	}
	 
	public IntArraySet(int n, Collection<Integer> coll) {
		this(n);
		if(coll.equals(null) || coll.contains(null)) {
			throw new NullPointerException();
		}
		for(int element: coll) {
			if(element < 0 || element >= n) {
				throw new IllegalArgumentException();
			}
			if(set[element] == false) {
				set[element] = true;
				size++;
			}
		}	
	}
	
	@Override
	public boolean add(Integer item) {
		Objects.nonNull(item);
		if(item < 0 || item >= n) throw new IllegalArgumentException();
		if(!set[item]) {
			set[item] = true;
			size++;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object item) {
		Objects.nonNull(item);
		int i = (int) item;
		if(i < 0 || i >= n || !set[i]) return false;
		set[i] = false;
		size--;
		return true;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new IntArraySetIterator();
	}

	@Override
	public int size() {
		return size;
	}

}
