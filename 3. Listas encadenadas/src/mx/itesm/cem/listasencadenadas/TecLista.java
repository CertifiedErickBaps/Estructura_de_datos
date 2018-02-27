package mx.itesm.cem.listasencadenadas;


public class TecLista<E> {	//Tipo parametrico
	protected static class Node<E> {
		public E info;		//Generico cualquier clase
		public Node<E> next;
		public Node(E info, Node<E> next) {
			this.info = info;
			this.next = next;
		}
		public Node(E info) {
			this(info, null);	//Este manda a llamar a otro constuctor
		}
	}
	
	protected Node<E> start = new Node<>(null);//Aqui se crea el centinela
	protected int size = 0; // o private int size;
	
	public void add(E info) {
		Node<E> nuevo = new Node<E>(info, start.next);
		start.next = nuevo;
		size++;
	}
	
	//Complejidad O(N)
	public int size() {
		return size;
//		int count = 0;
//		Node<E> p = start.next; Esto seria si no instanciamos el valor de size = 0;
//		while(p != null) {
//			count++;
//			p = p.next;
//		}
//		return count;
	}
	
	public E remove() {
		if(size() == 0) {
			return null;
		}
		E resultado = start.next.info;
		start.next = start.next.next;
		size--;
		return resultado;
	}
	
	public void dup() {
		Node<E> p = start.next;
		while(p != null) {
			Node<E> q = new Node<>(p.info, p.next);
			size++;
			p.next = q;
			p = p.next.next;
		}
	}
	
	public boolean removeAll(E element) {
		Node<E> p = start;
		boolean resultado = false;
		while(p.next != null) { //Sale cuando p.next es igual a null
			if(element.equals(p.next.info)) {
				resultado = true;
				size--;
				p.next = p.next.next;
			} else {
				p = p.next;	
			}
			
		}
		return resultado;
	}
	
	public void clear() {
		size = 0;
		start.next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("[");
		Node<E> node = start.next;
		while(node != null) {
			resultado.append(node.info);
			if(node.next != null) {
				resultado.append(", ");
			}
			node = node.next; //Avanza al siguiente modo
		}
		resultado.append("]");
		return resultado.toString();
		}
}
