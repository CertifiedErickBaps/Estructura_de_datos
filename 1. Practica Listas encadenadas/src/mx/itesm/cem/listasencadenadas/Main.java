package mx.itesm.cem.listasencadenadas;

public class Main {

	public static void main(String[] args) {
		TecLinkedList<String> lst = new TecLinkedList<>();
		lst.add("Hello");
		lst.add("Bye");
		System.out.println(lst);
		lst.add(2, "huevo");
		System.out.println(lst);
	}
}