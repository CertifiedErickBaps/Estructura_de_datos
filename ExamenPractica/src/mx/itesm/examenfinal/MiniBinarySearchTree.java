package mx.itesm.examenfinal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;

import mx.itesm.util.BinaryNode;
import mx.itesm.util.LinkedList;

public class MiniBinarySearchTree<E extends Comparable<E>> extends AbstractSet<E> {

	private BinaryNode<E> root = null;
	private int size = 0;

	@Override
	public Iterator<E> iterator() {
		return inOrderList().iterator();
	}

	@Override
	public int size() {
		return size;
	}

	public int diameter() {
		return 0;
	}

	private int diameter(BinaryNode<E> node) {
		return 0;
	}

	public int height(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}

		return (1 + Math.max(height(node.leftChild), height(node.rightChild)));
	}

	public List<E> inOrderList() {
		List<E> result = new LinkedList<E>();
		inOrder(root, result);
		return result;
	}

	private void inOrder(BinaryNode<E> node, List<E> result) {
		if (node == null) {
			return;
		}

		inOrder(node.leftChild, result);
		result.add(node.value);
		inOrder(node.rightChild, result);
	}

	public boolean add(E element) {
		if (root == null) {
			root = new BinaryNode<E>(element);
			size++;
			return true;
		} else {
			BinaryNode<E> currentNode = root;
			while (true) {
				if (element.compareTo(currentNode.value) == 0) {
					return false;
				} else if (element.compareTo(currentNode.value) < 0) {
					if (currentNode.leftChild == null) {
						currentNode.leftChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						currentNode = currentNode.leftChild;
					}
				} else {
					if (currentNode.rightChild == null) {
						currentNode.rightChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						currentNode = currentNode.rightChild;
					}
				}
			}
		}
	}

}