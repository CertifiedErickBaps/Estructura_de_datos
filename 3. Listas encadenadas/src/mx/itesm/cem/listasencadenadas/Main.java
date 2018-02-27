package mx.itesm.cem.listasencadenadas;

public class Main {
	public static void main(String[] args) {

		TecLista<String> lst = new TecLista<>();
		lst.dup();
		System.out.println(lst.size());
		System.out.println(lst);
		System.out.println(lst.remove());
		lst.add("hola");
		lst.add("adios");
		lst.dup();
		System.out.println(lst);
		System.out.println(lst.size());
		System.out.println(lst.remove());
		System.out.println(lst);
		System.out.println(lst.size());
		
		
		TecListaEnteros lst2 = new TecListaEnteros();
		lst2.add(4);
		lst2.add(8);
		lst2.add(15);
		lst2.add(16);
		lst2.add(24);
		lst2.add(42);
		System.out.println(lst2);
		System.out.println(lst2.suma());
		
		TecLista<String> lst3 = new TecLista<>();
		lst3.add("z");
		lst3.add("x");
		lst3.add("y");
		lst3.add("x");
		System.out.println(lst3);
		System.out.println(lst3.removeAll("x"));
		System.out.println(lst3);
		System.out.println(lst3.removeAll("x"));
		System.out.println(lst3);
		System.out.println(lst3.size());
		lst3.clear();
		System.out.println(lst3);
		System.out.println(lst3.size());
	}
}
