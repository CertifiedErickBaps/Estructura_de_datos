package mx.itesm.cem.forkjoin;

import java.util.concurrent.RecursiveAction;

/*----------------------------------------------------------
 * Práctica 7: Fork/Join
 * Fecha: 23-Abr-2018
 * Autores:
 *           A01378838 Eric Gómez Vázquez
 *           A01379896 Erick Bautista Perez
 *----------------------------------------------------------*/

@SuppressWarnings("serial")
public class CountSortAction extends RecursiveAction {
	private static final int LIMITE = 100;
	private int lo, hi;
	private int[] a;
	private int[] temp;
	
	public CountSortAction(int[] a, int[] temp, int lo, int hi) {
		this.lo=lo;
		this.hi=hi;
		this.a=a;
		this.temp=temp;
	}
	@Override
	protected void compute() {
		if(hi-lo < LIMITE) {
	        for (int i = lo; i < hi; i++) {
	            int count = 0;
	            for (int j = 0; j < a.length; j++) {
	                if (a[j] < a[i]) {
	                    count++;
	                } else if (a[i] == a[j] && j < i) {
	                    count++;
	                }
	            }
	            temp[count] = a[i];
	        }

		}else {
			int mid = (lo+hi)/2;
			CountSortAction a1 = new CountSortAction(a, temp, lo, mid);
			CountSortAction a2 = new CountSortAction(a, temp, mid, hi);
			invokeAll(a1,a2);
		}
	}

}
