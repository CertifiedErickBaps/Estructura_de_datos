package mx.itesm.cem.arboles;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*----------------------------------------------------------
 * Práctica 8: Árboles binarios
 * Fecha: 07-May-2018
 * Autores:
 *           A01378838 Eric Gómez Vázquez
 *           A01379896 Erick Bautista Perez
 *----------------------------------------------------------*/
public class BinarySearchTreeSet<E extends Comparable<E>>
        extends AbstractSet<E> {

    private static class Node<E> {
        private E data;
        private Node<E> izq;
        private Node<E> der;

        public Node(E data, Node<E> izq, Node<E> der) {
            this.data = data;
            this.izq = izq;
            this.der = der;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    private Node<E> root = null;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {        
        return inOrderList().iterator();
    }

    public List<E> preOrderList() {
        List<E> result = new LinkedList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node<E> p, List<E> result) {
        if (p != null) {
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
        if (p != null) {
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
        if (p != null) {
            postOrder(p.izq, result);
            postOrder(p.der, result);
            result.add(p.data);
        }
    }

    public List<E> levelOrderList() {
        List<E> result = new LinkedList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> p = queue.poll();
            if (p != null) {
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

    @Override
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            Node<E> p = root;
            while (true) {
                if (element.compareTo(p.data) == 0) {
                    return false;
                } else if (element.compareTo(p.data) < 0) {
                    if (p.izq == null) {
                        p.izq = new Node<>(element);
                        size++;
                        return true;
                    } else {
                        p = p.izq;
                    }
                } else { // element > p.data
                    if (p.der == null) {
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
    
    private Queue<Node<E>> listNodeTree(){
    	Queue<Node<E>> result = new LinkedList<>();
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> p = queue.poll();
			if (p != null) {
				queue.offer(p.izq);
				queue.offer(p.der);
				result.add(p);
			}
		}
		return result;
    }
    
    private boolean isLeaf(Node<E> p) {
		return p != null && p.izq == null && p.der == null;
	}
    
    
    public int height() {
		return height(root);
	}
	private int height(Node<E> p) {
		if(p == null) return -1;
		if(isLeaf(p)) return 0;
		return Math.max(height(p.izq), height(p.der)) + 1;
	}
	
	public boolean isFull() {
		Queue<Node<E>> result = listNodeTree();
		int count = 0;
		for(Node<E> e: result) {
			if((e.der != null & e.izq != null) || (isLeaf(e))) {
				count++;
			}
		}
		return count == size(); 
	}
	
	public int leafCount() {
		int count = 0;
		Queue<Node<E>> result = listNodeTree();
		for(Node<E> e : result) {
			if(isLeaf(e)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isPerfect() {
		Queue<Node<E>> result = listNodeTree(); 
		if(result.size() <= 1) return true;
		
		int valor = (int) Math.pow(2, height());
		if(result.size() > valor && isFull()) {
			while(result.size() != valor) {
				result.poll();
			}
			for(Node<E> e: result) {
				if(!isLeaf(e)) return false;
			}
			return true;
		}
		return false;
	}
	public boolean isDegenerate() {
		Queue<Node<E>> result = listNodeTree();
		if(result.size() <= 1) return false;
		int count = 0;
		for(Node<E> e: result) {
			if(e.der!= null && e.izq != null) return false;
			else if(e.der != null && e.izq == null || !(e.der != null && e.izq == null)) {
				count++;
			}
		}
		return count == size();
	}
}