package mx.itesm.util;

public class BinaryNode<E> {
	public E value;
	public BinaryNode<E> leftChild;
	public BinaryNode<E> rightChild;
	
	public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
		this.value = value;
		this.leftChild = left;
		this.rightChild = right;
	}
	
	public BinaryNode(E value) {
		this(value, null, null);
	}
}