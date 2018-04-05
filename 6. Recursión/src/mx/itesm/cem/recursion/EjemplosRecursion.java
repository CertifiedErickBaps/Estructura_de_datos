package mx.itesm.cem.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemplosRecursion {

	public static int factorial(int n) {
		if(n <= 0) return 1;
		
		return n * factorial(n-1);
	}
	
	public static <T extends Comparable<T>> List<T> quickSort(List<T> list){
		if(list.isEmpty()) {
			return list;
		}else {
			List<T> menores = new ArrayList<>();
			List<T> mayoresOIguales = new ArrayList<>();
			T pivote = list.get(0);			
			for(int i = 1; i <list.size(); i++) {
				T element = list.get(i);
				if(element.compareTo(pivote) < 0) {
					menores.add(element);
				}else {
					mayoresOIguales.add(element);
				}
			}
			menores = quickSort(menores);
			mayoresOIguales = quickSort(mayoresOIguales);
			menores.add(pivote);
			menores.addAll(mayoresOIguales);
			return menores;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(factorial(0));
//		System.out.println(factorial(4));
//		System.out.println(factorial(5));
//		System.out.println(factorial(19));
//
//		List<Integer> lst = Arrays.asList(3,5,7,1,8,0,2,6);
//		System.out.println(lst);
//		System.out.println(quickSort(lst));
		
		String s = "Anita lava la tina.";
		StringBuilder cadena = new StringBuilder();
		StringBuilder reverso = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			Character a = s.charAt(i);
			if(Character.isLetterOrDigit(a)) {
				cadena.append(a);
				reverso.append(a);
			}
		}
		
		reverso.reverse();
		System.out.println(cadena.toString().toLowerCase().equals(reverso.toString().toLowerCase()));
	}

}
