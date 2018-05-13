package mx.itesm.cem.arboles;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class BinarySearchTreeSet<E extends Comparable> extends AbstractSet<E> {

	protected static class Node<E> {
		private E data;		//Generico cualquier clase
		private Node<E> izq;
		private Node<E> der;
		
		
		public Node(E data, Node<E> izq, Node<E> der) {
			super();
			this.data = data;
			this.izq = izq;
			this.der = der;
		}


		public Node(E data) {
			this(data, null, null);
		}
		
		
	}
	public Node<E> root = null;
	private int size = 0;
	
	@Override
	public Iterator<E> iterator() {
		return inOrderList().iterator();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E element) {
		if(root == null) {
			root = new Node<>(element);
			size++;
			return true;
		}else {
			Node<E> p = root;
			while(true) {
				if(element.compareTo(p.data) == 0) {
					return false;
				} else if(element.compareTo(p.data) < 0) {
					if(p.izq == null) {
						p.izq = new Node<>(element);
						size++;
						return true;
					}else {
						p = p.izq;
					}
				} else { // Element debe ser mayor a p.data
					if(p.der == null) {
						p.der = new Node<>(element);
						size++;
						return true;
					} else {
						p = p.der;
					}
				}
			
			}
		}
	}
	
	public List<E> preOrderList() {
		List<E> result = new LinkedList<>();
		preOrder(root, result);
		return result;
	}
	private void preOrder(Node<E> p, List<E> result) {
		if(p != null) {
			result.add(p.data);
			preOrder(p.izq, result);
			preOrder(p.der, result);
		}
	}

	public List<E> inOrderList() {
		List<E> result = new LinkedList<>();
		inOrder(root, result);
		return result;
	}
	private void inOrder(Node<E> p, List<E> result) {
		if(p != null) {
			inOrder(p.izq, result);
			result.add(p.data);
			inOrder(p.der, result);
		}
		
	}
	
	public List<E> postOrderList() {
		List<E> result = new LinkedList<>();
		postOrder(root, result);
		return result;
	}
	
	private void postOrder(Node<E> p, List<E> result) {
		if(p != null) {
			
			postOrder(p.izq, result);
			postOrder(p.der, result);
			result.add(p.data);
		}
		
	}

	public List<E> levelOrderList(){
		List<E> result = new LinkedList<>();
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node<E> p = queue.poll();
			if(p != null) {
				queue.offer(p.izq);
				queue.offer(p.der);
				result.add(p.data);
			}
		}
		return result;
	}
	@Override
	public int size() {
		return size;
	}
	
	public E max() {
		if(root == null) {
			return null;
		} else {
			return max(root);
		}
		
	}
	private boolean isLeaf(Node<E> p) {
		return p != null && p.izq == null && p.der == null;
	}
	private E max(Node<E> p) {
		if(p == null) {
			return null;
		}
		while(p.der != null) {
			p = p.der;
		}
		return p.data;
	}
	
	private E max2() {
		E result = null;
		for(E e: this) {
			result = e;
		}
		return result;
	}
	
	public int height() {
		return height(root);
	}
	private int height(Node<E> p) {
		if(p == null) {
			return -1;
		}
		if(isLeaf(p)) {
			return 0;
		}
		return Math.max(height(p.izq), height(p.der)) + 1;
	}
	public static void main(String[] args) {
		BinarySearchTreeSet<Integer> tree = new BinarySearchTreeSet<>();
		tree.addAll(Arrays.asList(22, 30, 25, 35,
                10, 5, 33, 15, 12, 40, 17, 19, 20, 18, 16));
		System.out.println(tree.preOrderList());
		System.out.println(tree.inOrderList());
		System.out.println(tree.postOrderList());
		System.out.println(tree.levelOrderList());
		System.out.println(tree.max());
		for(int i: tree) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println(tree.max2());
		System.out.println(tree.height());
		
		BinarySearchTreeSet<Integer> tree2 = new BinarySearchTreeSet<>();
		tree2.addAll(Arrays.asList(7,15,10,5,2,6,0,18,12,3,9,14));
		System.out.println(tree2.height());
	}

}
