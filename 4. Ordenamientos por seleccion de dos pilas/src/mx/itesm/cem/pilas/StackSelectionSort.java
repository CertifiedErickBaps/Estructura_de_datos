package mx.itesm.cem.pilas;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StackSelectionSort {

    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        Deque<T> stack1 = new LinkedList<>(list);
        Deque<T> stack2 = new LinkedList<>();
        int n = list.size();

        for (int i = n; i > 1; i--) {
            T max = stack1.peek();
            for (int j = 0; j < i; j++) {
                T x = stack1.pop();
                stack2.push(x);
                if (max.compareTo(x) < 0) {
                    max = x;
                }
            }
            stack1.push(max);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                T x = stack2.pop();
                if (!found && x.compareTo(max) == 0) {
                    found = true;
                } else {
                    stack1.push(x);
                }

            }
        }

        for (int i = 0; i < n; i++) {
            list.set(i, stack1.pop());
        }

    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        Random r = new Random(17);
        for (int i = 0; i < 20; i++) {
            a.add(r.nextInt(100));
        }
        System.out.println(a);
        selectionSort(a);
        System.out.println(a);
        List<Estudiante> e = new ArrayList<>();
        e.add(new Estudiante("A011111111", "Juan"));
        e.add(new Estudiante("A091111111", "Pedro"));
        e.add(new Estudiante("A041111111", "Maria"));
        System.out.println(e);
        selectionSort(e);
        System.out.println(e);
    }
}