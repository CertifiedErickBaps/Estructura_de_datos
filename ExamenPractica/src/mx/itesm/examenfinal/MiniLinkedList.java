package mx.itesm.examenfinal;

import java.util.AbstractList;

import mx.itesm.util.Node;

public class MiniLinkedList<E> extends AbstractList<E>{
	private Node<E> head;
	
	public MiniLinkedList() {
		head = new Node<E>();
	}
	
	@SafeVarargs
	public MiniLinkedList(E... elements) {
		head = new Node<E>();
		
		for (E element : elements) {
			addLast(element);
		}
	}
	
	@Override
	public int size() {
		return recursiveSize(head);
	}
	
	private int recursiveSize(Node<E> node) {
		if(node.next == head) {
			return 0;
		}else {
			int n = 1;
			return n + recursiveSize(node.next);
		}
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		
		Node<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode.value;
	}
	
	public void addLast(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> previousLast = head.prev;
		
		previousLast.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		newNode.prev = previousLast;
	}
}