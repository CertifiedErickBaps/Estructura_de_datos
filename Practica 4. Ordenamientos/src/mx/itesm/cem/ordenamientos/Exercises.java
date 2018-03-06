package mx.itesm.cem.ordenamientos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*----------------------------------------------------------
 * Práctica 3: Ejercicios con pilas y filas
 * Fecha: 26-Feb-2018
 * Autores:
 *           A01379896 Erick Bautista Perez
 *           A013788838 Eric Gomez Vazquez
 *----------------------------------------------------------*/
public class Exercises {
	public static <T extends Comparable<T>> List<T> selectionSort(List<T> list){
		List<T> copia = new LinkedList<>(list);
		List<T> listaR = new LinkedList<>();
		
		while(!copia.isEmpty()) {
			T min = copia.get(0);
			for(T element : copia) {
				if(element.compareTo(min) <= 0) min = element;
			}
			listaR.add(min);
			copia.remove(min);
		}
		return listaR;	
	}
	
	public static List<Integer> bucketSort(List<Integer> list){
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
		
		while(!copia.isEmpty()) {
			if(copia.get(0) <= 9 && copia.get(0) >= 0) cero.add(copia.remove(0));
			else if(copia.get(0) <= 19 && copia.get(0) >= 10) uno.add(copia.remove(0));
			else if(copia.get(0) <= 29 && copia.get(0) >= 20) dos.add(copia.remove(0));
			else if(copia.get(0) <= 39 && copia.get(0) >= 30) tres.add(copia.remove(0));
			else if(copia.get(0) <= 49 && copia.get(0) >= 40) cuatro.add(copia.remove(0));
			else if(copia.get(0) <= 59 && copia.get(0) >= 50) cinco.add(copia.remove(0));
			else if(copia.get(0) <= 69 && copia.get(0) >= 60) seis.add(copia.remove(0));
			else if(copia.get(0) <= 79 && copia.get(0) >= 70) siete.add(copia.remove(0));
			else if(copia.get(0) <= 89 && copia.get(0) >= 80) ocho.add(copia.remove(0));
			else if(copia.get(0) <= 99 && copia.get(0) >= 90) nueve.add(copia.remove(0));
		}
		Collections.sort(cero);
		Collections.sort(uno);
		Collections.sort(dos);
		Collections.sort(tres);
		Collections.sort(cuatro);
		Collections.sort(cinco);
		Collections.sort(seis);
		Collections.sort(siete);
		Collections.sort(ocho);
		Collections.sort(nueve);
		
		List<Integer> actual = new LinkedList<>();
		actual.addAll(cero);
		actual.addAll(uno);
		actual.addAll(dos);
		actual.addAll(tres);
		actual.addAll(cuatro);
		actual.addAll(cinco);
		actual.addAll(seis);
		actual.addAll(siete);
		actual.addAll(ocho);
		actual.addAll(nueve);
		return actual;	
	}
	
}
