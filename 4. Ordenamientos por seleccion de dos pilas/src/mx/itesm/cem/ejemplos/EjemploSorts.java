package mx.itesm.cem.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EjemploSorts {

	public static void main(String[] args) {
		int[] ai = {5, -10, 5, 7, 4, 2, 7, 1, 10, 6};
		System.out.println(Arrays.toString(ai));
		Arrays.sort(ai);
		System.out.println(Arrays.toString(ai));
//		List<Integer> li = Arrays.asList(5, -10, 5, 7, 4, 2, 7, 1, 10, 6);
		List<Integer> li = new ArrayList<>(List.of(5, -10, 5, 7, 4, 2, 7, 1, 10, 6));
		List<Integer> la = new ArrayList<>(List.of(5, -10, 5, 7, 4, 2, 7, 1, 10, 6));
		List<Integer> listaR = new ArrayList<>();
		
		System.out.println(li);
		Collections.sort(li);
		System.out.println(li);
	}

}
