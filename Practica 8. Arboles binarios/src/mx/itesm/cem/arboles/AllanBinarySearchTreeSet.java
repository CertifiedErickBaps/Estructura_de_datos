package mx.itesm.cem.arboles;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllanBinarySearchTreeSet<E extends Comparable<E>>
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
    private boolean isEmpty(Node<E> p) {// Se crea un valor que se repetira en todo el codigo
		return p == null;
	}
    public int height() {
    	return height(root); //En este caso mandamos a llamar a la misma funcion
    }
    
    public int height(Node<E> p) {// Se crea un nodo p que es el root del arbol
    	if(isEmpty(p)) {
    		return -1;
    	}
    	return Math.max(height(p.izq), height(p.der)) + 1;
    }
    
    public boolean isFull() {
    	return isFull(root);
    }
    public boolean isFull(Node<E> p) {
    	if(isEmpty(p)) { // caso arbol vacio
    		return true;
    	}
    	else if(!isEmpty(p.izq) && isEmpty(p.der) || //Si el nodo derecho es nulo no es arbol full y viceversa
    			isEmpty(p.izq) && !isEmpty(p.der)) {
    		return false;
    	}
    	else if(isFull(p.der) && isFull(p.izq)) { //Metodo recursivo para pasar por todo el arbol
			return true;
		}else{
			return false;
		}	
    }

    public int leafCount() {
    	return leafCount(root);
    }
    public int leafCount(Node<E> p) {
    	if(isEmpty(p)) { //Primer caso que este vacio
    		return 0;
    	}
		else if(!isEmpty(p) && isEmpty(p.izq) && isEmpty(p.der)) { //Cuenta las hojas del arbol usando recursividad
			return 1;
		}else {
			return leafCount(p.der) + leafCount(p.izq);
		}
		
    }
    
    public boolean isPerfect() {
    	return isPerfect(root);
    }
    public boolean isPerfect(Node<E> p) {
    	if (isEmpty(p)) {
			return true;
		}
		int altura1 = 0;
		int altura2 = 0;
		if (!isEmpty(p.izq)) {
			altura1 = height(p.der); //Checa la altura del primer lado
		}
		if (!isEmpty(p.der)) {
			altura2 = height(p.izq); //Checa la altura del segundo lado
		}
		if(altura1 == altura2) { //Checamos si tiene el mismo nivel
			if(isFull(p)) { //Se checa que sea full
				return true;
			}else {
				return false;
			}
		}else {
			return false; //Si no, no es perfecto
		}
    }
    
    public boolean isDegenerate() {
		return isDegenerate(root);
	}
	
	public boolean isDegenerate(Node<E> p) {
		if(isEmpty(p) || isEmpty(p.izq) && isEmpty(p.der)) { //Esta vacio o por lo menos un nodo
			return false;
		}
		int hojas = 0;
		while(!isEmpty(p)) {
			if(!isEmpty(p.der) && !isEmpty(p.izq)) { //Tiene dos hijos
				return false;
			}
			if(!isEmpty(p.der) && isEmpty(p.izq)) {
				p = p.der;
				hojas++;
			}else {
				p = p.izq;
				hojas++;
			}
		}
		return hojas == size(); //Si todo el arbol es degenerado regresa true si no false
	}
}