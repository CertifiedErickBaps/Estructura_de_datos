package mx.itesm.cem.ordenamientos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*----------------------------------------------------------
 * Práctica 4: Ordenamientos
 * Fecha: 08-Mar-2018
 * Autores:
 *           A01379896 Erick Bautista Perez
 *           A013788838 Eric Gomez Vazquez
 *----------------------------------------------------------*/

public class Exercises {
	public static <T extends Comparable<T>> List<T> selectionSort(List<T> list) {
		List<T> copia = new LinkedList<>(list);
		List<T> resultante = new LinkedList<>();

		while (!copia.isEmpty()) {
			T min = copia.get(0);
			for (T element : copia) {
				if (element.compareTo(min) <= 0) {
					min = element;
				}
			}
			resultante.add(min);
			copia.remove(min);
		}
		return resultante;
	}

	public static List<Integer> bucketSort(List<Integer> list) {
		List<Integer> copia = new LinkedList<>(list);
		List<Integer> cero = new LinkedList<>();
		List<Integer> uno = new LinkedList<>();
		List<Integer> dos = new LinkedList<>();
		List<Integer> tres = new LinkedList<>();
		List<Integer> cuatro = new LinkedList<>();
		List<Integer> cinco = new LinkedList<>();
		List<Integer> seis = new LinkedList<>();
		List<Integer> siete = new LinkedList<>();
		List<Integer> ocho = new LinkedList<>();
		List<Integer> nueve = new LinkedList<>();
		List<List<Integer>> todo = Arrays.asList(cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve);
		while (!copia.isEmpty()) {
			if (copia.get(0) <= 9 && copia.get(0) >= 0) cero.add(copia.remove(0));
			else if (copia.get(0) <= 19 && copia.get(0) >= 10) uno.add(copia.remove(0));
			else if (copia.get(0) <= 29 && copia.get(0) >= 20) dos.add(copia.remove(0));
			else if (copia.get(0) <= 39 && copia.get(0) >= 30) tres.add(copia.remove(0));
			else if (copia.get(0) <= 49 && copia.get(0) >= 40) cuatro.add(copia.remove(0));
			else if (copia.get(0) <= 59 && copia.get(0) >= 50) cinco.add(copia.remove(0));
			else if (copia.get(0) <= 69 && copia.get(0) >= 60) seis.add(copia.remove(0));
			else if (copia.get(0) <= 79 && copia.get(0) >= 70) siete.add(copia.remove(0));
			else if (copia.get(0) <= 89 && copia.get(0) >= 80) ocho.add(copia.remove(0));
			else if (copia.get(0) <= 99 && copia.get(0) >= 90) nueve.add(copia.remove(0));
		}
		List<Integer> actual = new LinkedList<>();
		for(List<Integer> element : todo) {
			Collections.sort(element);
			actual.addAll(element);
		}
		return actual;
	}

	public static <T extends Comparable<T>> List<T> bogoSort(List<T> list) {
		List<T> copia = new LinkedList<>(list);
		boolean chido = true;
		while (chido) {
			boolean flag = true;
			for (int i = 0; i < copia.size() - 1; i++) {
				if (copia.get(i).compareTo(copia.get(i + 1)) > 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				chido = false;
			} else {
				Collections.shuffle(copia);
			}
		}
		return copia;
	}
	
	public static <T extends Comparable<T>> List<T> quickSort(List<T> list){
		if(list.isEmpty())	return list;
		
		List<T> mayores = new ArrayList<>();
		List<T> menores = new ArrayList<>();
		List<T> actual = new ArrayList<>();
		T pivote = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i).compareTo(pivote) >= 0){
				mayores.add(list.get(i));
			}else {
				menores.add(list.get(i));
			}
		}
		
		actual.addAll(quickSort(menores));
		actual.add(pivote);
		actual.addAll(quickSort(mayores));
		return actual;
	}

}