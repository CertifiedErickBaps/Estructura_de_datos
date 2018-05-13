package mx.itesm.cem.forkjoin;

/*----------------------------------------------------------
 * Práctica 7: Fork/Join
 * Fecha: 23-Abr-2018
 * Autores:
 *           A01378838 Eric Gómez Vázquez
 *           A01379896 Erick Bautista Perez
 *----------------------------------------------------------*/

import java.util.Random;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class MonteCarloTask extends RecursiveTask<Integer> {
	public static final int LIMITE = 1000;
	private int lo, hi;
	public MonteCarloTask(int lo, int hi) {
		this.hi=hi;
		this.lo=lo;
	}
	@Override
	protected Integer compute() {
		if(hi-lo<LIMITE) { //comienza codigo especifico del factorial
			Random rnd = new Random();
	        int sum = 0;
	        for (int i = lo; i < hi; i++) {
	            double x = rnd.nextDouble() * 2 - 1;
	            double y = rnd.nextDouble() * 2 - 1;
	            double h = x * x + y * y;
	            if (h <= 1) {
	                sum++;
	            }
	        }
			return sum;
		}else {
			int mid = (hi+lo)/2;
			MonteCarloTask t1 = new MonteCarloTask(lo, mid);
			MonteCarloTask t2 = new MonteCarloTask(mid, hi);
			t1.fork(); //ejecuta en paralelo
			Integer r1 = t2.compute();
			Integer r2 = t1.join();
			return Integer.sum(r1, r2);
		}
	}
	
}
