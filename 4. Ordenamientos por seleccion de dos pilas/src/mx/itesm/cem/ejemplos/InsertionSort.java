package mx.itesm.cem.ejemplos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mx.itesm.cem.pilas.Estudiante;

public class InsertionSort {
	public static <T extends Comparable<T>> List<T> sort(List<T> list){
		List<T> copia = new LinkedList<>(list);
		List<T> resultado = new LinkedList<>();
		while(!copia.isEmpty()) {
			T element = copia.remove(0);
			int indice = 0;
			while(indice < resultado.size() &&
					element.compareTo(resultado.get(indice)) >= 0) {
				indice++;
			}
			resultado.add(indice, element);
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>(List.of(
				"x", "t","a", "c", "p", "c", "a", "z", "b"));
		System.out.println(ls);
		System.out.println(sort(ls));
		
		List<Estudiante> le = new ArrayList<>(List.of(
				new Estudiante("123", "Juan"),
				new Estudiante("123", "Abelardo"),
				new Estudiante("123", "Montoya"),
				new Estudiante("123", "Lucas")));
		System.out.println(le);
		System.out.println(sort(le));
	}

}
