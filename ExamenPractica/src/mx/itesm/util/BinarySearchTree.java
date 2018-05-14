package mx.itesm.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>>
			extends AbstractSet<E> {
	//left es Izquierda 
	//right es Derecha

	private BinaryNode<E> root = null;
	private int size = 0;
	
	/**
	 * Devuelve la altura de este árbol binario. 
	 * @return -1 si el árbol está vacío. 0 si el árbol sólo tiene un nodo.
	 */
	public int height(){
		return heightList(root);
	
	}
	public int heightList(BinaryNode<E> node) {
		int Lheight = 0;
		int Rheight = 0;
		if(node == null) {
			return 0;
		}
		if(node.rightChild == null && node.leftChild == null) {
			return 0;
		}
		if(node.rightChild == null) {
			Lheight = heightList(node.leftChild);
		}else {
		    Rheight = heightList(node.rightChild);
		}
		
		if(Lheight > Rheight) {
			return Lheight + 1 ;
		}else {
			return Rheight + 1;
		}
	}
	
	
	/**
	 * Devuelve true si este árbol binario está lleno, 
	 * o false en caso contrario. 
	 * Un árbol binario lleno es aquel en el que cada 
	 * nodo tiene cero o dos hijos. Como caso especial, 
	 * un árbol vacío se considera lleno.
	 * @return true si este árbol binario está lleno, 
	 * false en caso contrario.
	 */
//	Primero, para ver si esta vacia tenemos que hacer node == null
//	entonces esta vacia
	public boolean isFull() {
		return isFullList(root);
	}
	public boolean isFullList(BinaryNode <E> node) {
		int Lheight = 0;
		int Rheight = 0;
		//La comprobacion de que el metodo es falso se hace dentro del programa
		if(node == null) {
			return false;
		}
		if(node.rightChild == null) {
			Lheight = heightList(node.leftChild);
		}else {
		    Rheight = heightList(node.rightChild);
		}
		
		if(Lheight > Rheight) {
			return false ;
		}else if(Rheight < Lheight){
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Devuelve el número de hojas con las que cuenta 
	 * este árbol binario.
	 * @return número de hojas de este árbol binario.
	 */
	
	public int leafCount() {
		return leafCountList(root);		
	}
	public int leafCountList(BinaryNode<E> node) {	
		if(node == null) {
			return 0;
		}
		if(node.leftChild == null && node.rightChild == null) {
			return 1;}
		else if(node.leftChild == null) {
			return  leafCountList(node.rightChild);
		}
		else if(node.rightChild == null) {
			return leafCountList(node.leftChild);
		}else {
			return leafCountList(node.leftChild) + leafCountList(node.rightChild);

		}
	}
	/**
	 * Devuelve true si este árbol binario es perfecto, 
	 * o false en caso contrario. Se dice que un árbol 
	 * binario es perfecto si está lleno y si además 
	 * todas sus hojas están al mismo nivel.
	 * @return true si es un árbol binario perfecto,
	 * false de lo contrario.
	 */
	public boolean isPerfectList(BinaryNode<E> node) {
		
		if(isFullList(node) == false) {
			return false;
			}
		else if(node.leftChild == null && node.rightChild == null) {
			return true;
			}
		else if(node.leftChild == null || node.rightChild == null) {
			return false;
		}
		else {return isPerfectList(node.leftChild) && isPerfectList(node.rightChild);}
	}
	
	public boolean isPerfect() {
		return isPerfectList(root);
	}
	public boolean wtf() {
		if(root.leftChild == null) {
			System.out.println("well fuck");
			return true;
		}
		else
		{
			System.out.println("bad religion");
			return false;
		}	
	}
	
	/**
	 * Devuelve true si este árbol binario es un árbol 
	 * degenerado, o false en caso contrario. Se dice 
	 * que un árbol es degenerado si por cada nodo padre 
	 * existe solamente un nodo hijo asociado. En términos 
	 * de eficiencia, un árbol degenerado se comporta 
	 * exactamente como una lista encadenada.
	 * @return true si es un árbol binario degenerado,
	 * false de lo contrario.
	 */
	public boolean isDegenerateList(BinaryNode<E> node){
		if(node == null) {
			return false;
		}
		//Puede tener solo 1 nodo, el otro debe de estar apuntando a null y para que cuando salga un negativo vamos a 
		//Cuando sale un solo elemento falso se termina la recurcion y con un AND haces que toda la recurcion sea negativa
		if(node.rightChild != null && node.leftChild != null) {return true;}
		else if(node.rightChild != null || node.leftChild != null){
			if(node.rightChild != null) {
				return true &&	isDegenerateList(node.rightChild);
			}else if(node.rightChild != null && node.leftChild != null) {

				return false;
			}
			else {
				return true && isDegenerateList(node.leftChild);
			}

		}else {
			if(node.rightChild == null && node.leftChild == null) {
				return true;
			}else {
				return false;
			}
		}
	}
	public boolean isDegenerate() {
		return isDegenerateList(root);
	}
	
	public List<E> preOrderList(){
		List<E> result = new LinkedList<E>();
		preOrder(root, result);
		return result;
	}
	
	private void preOrder(BinaryNode<E> node, List<E> result) {
		if (node == null) {
			return;
		}
		
		result.add(node.value);
		preOrder(node.leftChild, result);
		preOrder(node.rightChild, result);
	}
	
	public boolean add(E element) {
		if (root == null) {
			root = new BinaryNode<E>(element);
			size++;
			return true;
		} else {		
			BinaryNode<E> curreode = root;
			while (true) {
				if (element.compareTo(curreode.value) == 0) {
					return false;
				} else if (element.compareTo(curreode.value) < 0) {
					if (curreode.leftChild == null) {
						curreode.leftChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						curreode = curreode.leftChild;
					}
				} else {
					if (curreode.rightChild == null) {
						curreode.rightChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						curreode = curreode.rightChild;
					}
				}
			}
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> arbol = new BinarySearchTree<Integer>();
		tree.add(4);
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(20);
		tree.add(15);
		tree.add(17);
		tree.add(7);
		tree.add(5);
		arbol.add(1);
		arbol.add(2);
		arbol.add(3);
		System.out.println(tree.preOrderList());
		System.out.println(tree.height());
		System.out.println("esta es informacion de ARBOL: ");
		System.out.println(arbol.preOrderList());
		System.out.println("la profundidad del arbol: "+ arbol.height());
		System.out.println("Si el tree esta lleno: " + arbol.isFull());
		System.out.println("Las hojas que tiene tree: " + arbol.leafCount());
		System.out.println("Es un arbol perfecto: " + arbol.isPerfect());
		System.out.println("Es un arbol Degenerado?? "+ arbol.isDegenerate());
	}

}