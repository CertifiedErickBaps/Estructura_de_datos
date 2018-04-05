package mx.itesm.cem.recursion;

import java.util.List;

public class RecursiveAlgorithms {

	/*----------------------------------------------------------
	 * Práctica 6: Recursión
	 * Fecha: 06-Abr-2018
	 * Autores:
	 *           A01378838 Eric Gómez Vázquez
	 *           A01379896 Erick Bautista Perez
	 *           
	 *----------------------------------------------------------*/
	
	public static int gcd(int m, int n) {
		int result = 0;
		if(m == n) {
			result = m;
		}else if(m > n) {
			return gcd(m - n, n);
		}else if(m < n) {
			return gcd(m, n - m);
		}
		return result;	
	}
	
	public static int pow(int base, int exponent) {
		final int DECREMENTAL = 1;
		if(exponent == 0) {
			return 1;
		}
		return base * pow(base, exponent - DECREMENTAL);
	}
	
	public static int max(List<Integer> list) {
		if(list.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int first = list.get(0);
		List<Integer> listR = list.subList(1, list.size());
		int max = max(listR);	
		if(first > max) {
			return first;
		}
		return max;
	}
	
	public static int consecutiveAddition(int start, int end) {
		if(start > end) {
			return 0;
		}
		return start + consecutiveAddition(start+1, end);
	}
	
	public static String toBinary(int n) {
		String cadena = "";
		if(n == 0) {
			return cadena;
		}
		return toBinary(n / 2) + Integer.toString(n % 2);
	}
	
	public static boolean isPalindrome(String s) {
		if(s.length() <= 1) return true;
		s = s.toLowerCase();
		StringBuilder cadena = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			Character a = s.charAt(i);
			if(Character.isLetter(a)) {
				cadena.append(a);
			}
		}
		if (cadena.charAt(0) == cadena.charAt(cadena.length()-1)) {
			return isPalindrome(cadena.substring(1, cadena.length()-1));
		}
		return false;
	}
}
