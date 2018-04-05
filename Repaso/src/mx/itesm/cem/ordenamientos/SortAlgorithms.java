package mx.itesm.cem.ordenamientos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAlgorithms {

    public static <T extends Comparable<T>> List<T> bogoSort(
            List<T> list) {
        List<T> x = new ArrayList<>(list);
        while (!isOrdered(x)) {
            System.out.println("Desorden: " + x);
            Collections.shuffle(x);
        }
        return x;
    }

    private static <T extends Comparable<T>> boolean isOrdered(
            List<T> x) {
        for (int i = 0; i < x.size() - 1; i++) {
            if (x.get(i).compareTo(x.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("b", "a", "d", "f",
                "c", "e", "x", "y", "z", "t");
        System.out.println(a);
        System.out.println(bogoSort(a));
    }

}