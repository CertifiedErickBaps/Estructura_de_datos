package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuickSortTest {
	private boolean estaOrdenado(int[] lista) {
		boolean estaOrdenado = true;
		for (int i = 1; i < lista.length; i++) {
			estaOrdenado = estaOrdenado && (lista[i - 1] <= lista[i]);
		}
		return estaOrdenado;
	}
	@Test
	public void probarUnaListaOrdenada() {
		int[] lista = { 9, 8, 7, 6, 5, 4, 3, 2, 1};

		Arrays.quickSort(lista,0,lista.length-1);

		assertTrue(estaOrdenado(lista));
	}
}
