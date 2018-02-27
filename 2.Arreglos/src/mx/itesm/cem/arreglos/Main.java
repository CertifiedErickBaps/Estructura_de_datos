package mx.itesm.cem.arreglos;

public class Main {

		public static int suma(TecArrayList<Integer> lista) {
			int resultado = 0;
			for(int i = 0; i < lista.size(); i++) {
				resultado += lista.get(i);
			}
			return resultado;
		}
		
		public static void main(String[] args) {
			TecArrayList<Integer> a = new TecArrayList<>(10,22,31,41);
//			int s = suma(a);
			//System.out.println(a);
			a.remove(1);
			System.out.println(a);
		}
		
}
//Implementar la operacion remove.