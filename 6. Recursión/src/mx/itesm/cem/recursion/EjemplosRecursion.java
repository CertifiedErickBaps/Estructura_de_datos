package mx.itesm.cem.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	
	public static void hanoi(int n, String origen, String temp, String destino) {
		if(n == 1) {
			System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
		} else {
			hanoi(n - 1, origen, destino, temp);
			System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
			hanoi(n - 1, temp, origen, destino);
		}
		
		
	}
	
	public static <T> List<T> reverse(List<T> lst){
		if(lst.isEmpty()) {
			return new LinkedList<T>();
		} else {
			T primero = lst.get(0);
			List<T> resto = lst.subList(1, lst.size());
			List<T> reversoResto = reverse(resto);
			reversoResto.add(primero);
			return reversoResto;
		}
		
	}
	
	public static int sum(List<Integer> lst) {
		if(lst.isEmpty()) {
			return 0;
		}
		int start = lst.get(0);
		return start + sum(lst.subList(1, lst.size()));
	}
	
	public static <T> List<T> duplicate(List<T> lst){
		if(lst.isEmpty()) {
			return new LinkedList<T>();
		} else {
			T primero = lst.get(0);
			List<T> duplica = lst.subList(1, lst.size());
			List<T> duplicaResto = duplicate(duplica);
			duplicaResto.add(0, primero);
			duplicaResto.add(0, primero);
			return duplicaResto;
		}
	}
	
	public static int dotProduct(List<Integer> a, List<Integer> b) {
		if(a.isEmpty() || b.isEmpty()) {
			return 0;
		}
		return a.get(0)* b.get(0) + dotProduct(a.subList(1, a.size()), b.subList(1, b.size()));
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
		
//		String s = "Anita lava la tina.";
//		StringBuilder cadena = new StringBuilder();
//		StringBuilder reverso = new StringBuilder();
//		for(int i = 0; i < s.length(); i++) {
//			Character a = s.charAt(i);
//			if(Character.isLetterOrDigit(a)) {
//				cadena.append(a);
//				reverso.append(a);
//			}
//		}
//		
//		reverso.reverse();
//		System.out.println(cadena.toString().toLowerCase().equals(reverso.toString().toLowerCase()));
//		List<String> s = Arrays.asList("a", "b", "c", "d", "e");
//		System.out.println(reverse(s));
//		
//		System.out.println(duplicate(s));
//		hanoi(2, "A", "B", "C");	
//		List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		System.out.println(sum(lst));
		List<Integer> lst1 = Arrays.asList(1,2,3);
		List<Integer> lst2 = Arrays.asList(1,2,3);
		System.out.println(dotProduct(lst1, lst2));
	}

}
