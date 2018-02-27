/*---------------------------------------------------------
 * A01379896 Erick Bautista P�rez.
 *---------------------------------------------------------
 */

package mx.itesm.cem.examen1;

import java.util.NoSuchElementException;

/**
 * Implementaci�n de una lista sencillamente encadenada, con
 * centinela, que contiene enteros exclusivamente.
 * 
 * @author Ariel Ortiz
 */
public class IntList {

    private static class Node {
        int data = 0;
        Node next = null;
    }

    private Node sentinel;

    /**
     * Constructor de la clase.
     */
    public IntList() {
        sentinel = new Node();
    }

    /**
     * Agrega un elemento a esta lista, insert�ndolo en el
     * lugar correspondiente con el fin de mantener la lista
     * en orden ascendente.
     * 
     * @param newData
     *            El elemento a agregar a esta lista.
     */
    public void add(int newData) {
        Node p = sentinel;
        while (p.next != null && newData > p.next.data) {
            p = p.next;
        }
        Node newNode = new Node();
        newNode.data = newData;
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * Devuelve la representaci�n como cadena de caracteres
     * de esta lista.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node p = sentinel.next;
        while (p != null) {
            result.append(p.data);
            if (p.next != null) {
                result.append(", ");
            }
            p = p.next;
        }
        result.append("]");
        return result.toString();
    }

    /**
     * Determina si esta lista contiene elementos.
     * 
     * @return true si la lista est� vac�a, o false en caso
     *         contrario.
     */
    public boolean isEmpty() {
        return sentinel.next == null;   	
    }

    /**
     * Determina el elemento con el valor m�s grande de esta
     * lista.
     * 
     * @return El elemento m�s grande de esta lista.
     * 
     * @throws NoSuchElementException
     *             si la lista no contiene elementos.
     */
    public int max() {
    	if(isEmpty()) {
        	throw new NoSuchElementException();
        }
        Node current = sentinel.next;
        Node max = new Node();
        while(current != null) {
        	if(current.data > max.data) {
        		max.data = current.data;
        		current = current.next;
        	}else {
        		current = current.next;
        	}
        }
        
        return max.data;
    }

    /**
     * Devuelve, como n�mero real de punto flotante, el
     * promedio (media aritm�tica) de todos los elementos
     * contenidos en esta lista.
     * 
     * @return El promedio de los valores de esta lista.
     * 
     * @throws NoSuchElementException
     *             si la lista no contiene elementos.
     */
    public double average() {
        if(isEmpty()) {
        	throw new NoSuchElementException();
        }
        Node current = sentinel.next;
        Node sum = new Node();
        int count = 0;
        double average;
        while(current != null) {
        	sum.data += current.data;
        	current = current.next;
        	count++;
        }
        average = (double) sum.data/count;
        return average;
    }

    /**
     * Remueve de esta lista todos los nodos cuyos valores
     * est�n comprendidos entre <code>start</code> y
     * <code>end</code>, inclusive.
     * 
     * @param start
     *            inicio inclusivo de rango.
     * @param end
     *            fin inclusivo de rango.
     * @return true si se elimin� por lo menos un nodo, o
     *         false si no se elimin� nodo alguno.
     * @throws IllegalArgumentException
     *             si end es menor que start.
     */
    public boolean removeBetween(int start, int end) {
        if(end < start) {
        	throw new IllegalArgumentException();
        }
        Node current = sentinel;
        boolean borrado = false;
        while (current.next != null) {
        	if(start <= current.next.data && current.next.data <= end) {
        		current.next = current.next.next;
        		borrado = true;
        	}else {
        		current = current.next;
        	}
        }
        return borrado;
    }
}
