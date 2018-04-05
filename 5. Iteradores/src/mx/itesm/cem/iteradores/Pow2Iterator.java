package mx.itesm.cem.iteradores;

import java.util.Iterator;
import java.util.NoSuchElementException;

// No es muy convencional que una clase implemente
// Iterable o Iterator al mismo tiempo
public class Pow2Iterator implements Iterable<Integer>, Iterator<Integer>{
	private int potencia = 1;
	private int max;
	
	public Pow2Iterator(int max) {
		this.max = max;
		this.potencia = 1;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return potencia <= max;
	}

	@Override
	public Integer next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		int resultado = potencia;
		potencia *= 2;
		return resultado;
	}

	public static void main(String[] args) {
		Iterator<Integer> it = new Pow2Iterator(1000);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		for(int i: new Pow2Iterator(100)) {
			System.out.println(i);
		}
	}
}
