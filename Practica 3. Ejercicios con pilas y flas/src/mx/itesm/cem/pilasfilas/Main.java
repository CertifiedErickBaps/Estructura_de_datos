package mx.itesm.cem.pilasfilas;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Queue<String> filaR = new LinkedList<>();
		filaR.add("Hola");
		filaR.add("Mundo");
		System.out.println(filaR.toString());
	}
}
