package mx.itesm.cem.filas;

import java.util.Scanner;

public class AESC {
	public static String divideVenceras(double x) {
		int n = (int) x;
		int suma = 0;
		String cadena = "";
		for(int i = 0; i < n; i++) {
			double form = (x / (Math.pow(2, i)));
			suma += (int) form;
		}
		cadena = Integer.toString(suma);
		return cadena;
	}
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double numero = entrada.nextDouble();
		System.out.println(divideVenceras(numero));
	}
}
