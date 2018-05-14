package mx.itesm.util;

public class Node<T> {
	public T value;
	public Node<T> next;
	public Node<T> prev;

	public Node() {
		value = null;
		next = this;
		prev = this;
	}

	public Node(T value) {
		this.value = value;
		next = this;
		prev = this;
	}
}