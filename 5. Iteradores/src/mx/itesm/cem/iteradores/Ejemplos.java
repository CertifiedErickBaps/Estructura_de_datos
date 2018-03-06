package mx.itesm.cem.iteradores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ejemplos {

	public static void main(String[] args) {
//		Crear una coleccion (inmutable)
		List<String> lst = Arrays.asList("manzana", "pera", "guayaba", "piña", "melon",
				"sandia", "naranja", "mango");
//		1. Visitar todos los elementos de lst
//		Usando un iterador explicito
		Iterator<String> iterador = lst.iterator();
		while(iterador.hasNext()) {
			String element = iterador.next();
			System.out.println(element);
		}
		
		System.out.println();
		
//		2. Visitar todos los elementos del lst
//		usando un for mejorado
		for(String elemento : lst) {
			System.out.println(elemento);
		}
	}

}
