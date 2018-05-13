package mx.itesm.cem.mapexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
//		TreeMap<>() regresa los elementos en orden ascendente
//		LinkeHashMap<>() inserta los elementos conforme se agregaron
		Map<String, String> dic = new HashMap<>();
//		Pollito es la llave y chicken es el valor
		dic.put("pollito", "chicken");
		dic.put("galina", "hen");
		dic.put("lápiz", "pencil");
		dic.put("pluma", "pen");
		dic.put("ventana", "window");
		dic.put("techo", "ceiling");
		dic.put("piso", "floor");
		
//		for(String key: dic.keySet()) {
//			System.out.println(key + ": " + dic.get(key));
//		}
		
		String cadena = "esta es una prueba";
		Map<Character, Integer> frecuencias = new HashMap<>();
		for(char c : cadena.toCharArray()) {
			if(frecuencias.containsKey(c)) {
				frecuencias.put(c, frecuencias.get(c) + 1);
			} else {
				frecuencias.put(c, 1);
			}
		}
		System.out.println(frecuencias);
		
		Map<String, List<String>> otro = new HashMap<>();
		otro.put("A", Arrays.asList("B"));
		otro.put("B", Arrays.asList("A", "C"));
		otro.put("C", Arrays.asList("D", "A"));
		otro.put("D", Arrays.asList());
		System.out.println(otro);
		
		List<String> lst = new ArrayList<>(Arrays.asList("tontin","gruñon", "dormilon", "doc", "estornudon", "feliz", "timido" ));
		//Ordenar de forma ascendente y de forma descente(-a.compareTo(b))
//		lst.sort((a, b)-> a.compareTo(b));
		lst.sort((a, b) -> Integer.compare(a.length(), b.length()));
		
		System.out.println(lst);
	}
	
}
