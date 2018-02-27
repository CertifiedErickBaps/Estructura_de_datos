package mx.itesm.cem.pilasfilas;

/*----------------------------------------------------------
 * Práctica 3: Ejercicios con pilas y filas
 * Fecha: 26-Feb-2018
 * Autores:
 *           A01379896 Erick Bautista Perez
 *           A013788838 Eric Gomez Vazquez
 *----------------------------------------------------------*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Exercises {
	
	public static java.util.Queue<String> tokenize(String in) {
	    java.util.regex.Pattern p = java.util.regex.Pattern
	            .compile("(\\s)|(\\d+)|(.)");
	    java.util.regex.Matcher m = p.matcher(in);
	    java.util.Queue<String> result = 
	        new java.util.LinkedList<String>();
	    while (m.find()) {
	        if (m.group(1) == null) {
	            result.add(m.group());
	        }
	    }
	    return result;
	}
	
	public static boolean balancedBrackets(String expr) {
		Deque<Character> pila = new LinkedList<>();
		for(int i=0; i<expr.length(); i++) {
			if(!Character.isDigit(expr.charAt(i))) {
				if(expr.charAt(i)=='(' || expr.charAt(i)=='{' || expr.charAt(i)=='[') {
					pila.push(expr.charAt(i));
				}else {
					if(pila.isEmpty()) {
						return false;
					}else if(expr.charAt(i)==')' && pila.pop()!='('){
						return false;
					}else if(expr.charAt(i)==']' && pila.pop()!='[') {
						return false;
					}else if(expr.charAt(i)=='}' && pila.pop()!='{') {
						return false;
					}
				}
			}
		}
		if(pila.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
		Queue<Integer> qResult = new LinkedList<>();
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(q1.element()<q2.element()) {
				qResult.add(q1.remove());
			}else {
				qResult.add(q2.remove());
			}
		}
		while(!q1.isEmpty()) {
				qResult.add(q1.remove());
		}
		while(!q2.isEmpty()) {
			qResult.add(q2.remove());
			
		}
		return qResult;
	}

	public static int evaluar(String operador, String a, String b) {
		int result1 = Integer.parseInt(a);
		int result2 = Integer.parseInt(b);
		
	    if (operador.equals("+")) return (result2 + result1);
	    if (operador.equals("-")) return (result2 - result1);
	    if (operador.equals("*")) return (result2 * result1);
	    if (operador.equals("/")) return (result2 / result1);
		return 0;
	}
	
	public static int postfixEvaluation(String expr) { //Notacion polaca inversa
		Deque<String> pila1 = new LinkedList<>();
		Queue<String> fila1 = tokenize(expr);
		String operadores = "+-*/";
		
		if(expr.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		while(!fila1.isEmpty()) {
			if(!(operadores.contains(fila1.element()))){
				pila1.push(fila1.remove());
			}else if(operadores.contains(fila1.element())){
				if(pila1.size() < 2) {
					throw new IllegalArgumentException();
				}
				int cEvaluar = evaluar(fila1.remove(), pila1.pop(), pila1.pop());
				String newValor = Integer.toString(cEvaluar);
				pila1.push(newValor);
			}else {
				throw new IllegalArgumentException();
			}
		}
		
		if(pila1.size() > 1 || pila1.contains(operadores)) {
			throw new IllegalArgumentException();
		}
		
		String result = pila1.peek();
		String nResult = result;
		int numero = Integer.parseInt(nResult);
		return numero;
	}	

	public static boolean hasHigherPrecedence(String stackTop, String operator) {
	    return !((stackTop.equals("+")
	            || stackTop.equals("-"))
	            && (operator.equals("*")
	                    || operator.equals("/")));
	}
	
	public static String convertInfixToPostfix(String expr) {
		Deque<String> pila = new LinkedList<>();
		Queue<String> filaR = new LinkedList<>();
		Queue<String> fila = tokenize(expr);
		String operador = "+-*/";
		
		String parentesis = "()";
		while(!(fila.isEmpty())) {
			if(!parentesis.contains(fila.element()) && !operador.contains(fila.element())) {
				filaR.add(fila.remove());
			}else if("(".equals(fila.element())) {
				pila.push(fila.remove());
			}else if(operador.contains(fila.element())) {
				while(!pila.isEmpty() && !"(".equals(pila.peek())) {
					String operador2 = fila.element();
					if(hasHigherPrecedence(pila.peek(), operador2)) {
						filaR.add(pila.pop());
					}else {
						break;
					}
				}
				pila.push(fila.remove());
			}else if(")".equals(fila.element())) {
				fila.remove();
				while(!"(".equals(pila.peek()) && !pila.isEmpty()) {
					filaR.add(pila.pop());
				}
				if(!pila.isEmpty()) {
					pila.pop();
				}
			} 
		}
		if(!pila.isEmpty()) {
			int n = pila.size();
			for(int i = 0; i < n; i++) {
				filaR.add(pila.pop());
			}
		}

		int size = filaR.size();
		StringBuilder n = new StringBuilder();
		for(int i = 0; i < size; i++) {
			if(i < size - 1) {
				n.append(filaR.remove() + " ");
			}else {
				n.append(filaR.remove());
			}	
		}
		return n.toString();
	}
}
