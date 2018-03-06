package mx.itesm.cem.ordenamientos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
		
		int i = 0;
		while(!copia.isEmpty()) {
			if(copia.get(i) <= 9 && copia.get(i) >= 0) cero.add(copia.remove(i));
			else if(copia.get(i) <= 19 && copia.get(i) >= 10) uno.add(copia.remove(i));
			else if(copia.get(i) <= 29 && copia.get(i) >= 20) dos.add(copia.remove(i));
			else if(copia.get(i) <= 39 && copia.get(i) >= 30) tres.add(copia.remove(i));
			else if(copia.get(i) <= 49 && copia.get(i) >= 40) cuatro.add(copia.remove(i));
			else if(copia.get(i) <= 59 && copia.get(i) >= 50) cinco.add(copia.remove(i));
			else if(copia.get(i) <= 69 && copia.get(i) >= 60) seis.add(copia.remove(i));
			else if(copia.get(i) <= 79 && copia.get(i) >= 70) siete.add(copia.remove(i));
			else if(copia.get(i) <= 89 && copia.get(i) >= 80) ocho.add(copia.remove(i));
			else if(copia.get(i) <= 99 && copia.get(i) >= 90) nueve.add(copia.remove(i));
			i++;
		}
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
