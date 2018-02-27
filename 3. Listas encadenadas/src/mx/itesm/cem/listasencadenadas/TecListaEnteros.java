package mx.itesm.cem.listasencadenadas;

public class TecListaEnteros extends TecLista<Integer> {
	public int suma() {
		Node<Integer> p = start.next;
		int count = 0;
		while(p != null) {
			count += p.info;
			p = p.next;
		}
		return count;
	}
	
}
