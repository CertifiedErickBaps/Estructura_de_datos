package mx.itesm.cem.pilas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {

    private class ArrayStackIterator implements Iterator<E> {

        private int current = top;
        
        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current--;
            return data[current];
        }

    }

    private E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        top = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    @Override
    public void push(E item) {
        if (top == data.length) {
            throw new IllegalStateException(
                    "Stack overflow");
        }
        data[top] = item;
        top++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "Stack underflow");
        }
        top--;
        E result = data[top];
        data[top] = null;
        return result;
    }

    @Override
    public E peek() {
        E item = pop();
        push(item);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return top;
    }
    
    @Override
    public String toString() {
        List<E> list = new ArrayList<>();
        for (E item: this) {
            list.add(item);
        }
        return "top -> " + list;
    }
    
    public static void main(String[] args) {
        Stack<String> s = new ArrayStack<>(5);
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        
        System.out.println();
        
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
        
        System.out.println();
        
        for (String item : s) {
            System.out.println(item);
        }
        
        System.out.println(s);
    }

}