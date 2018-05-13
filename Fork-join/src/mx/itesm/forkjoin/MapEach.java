package mx.itesm.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.function.IntUnaryOperator;

public class MapEach {

    private static class Timer {
        private long start;

        public void start() {
            start = System.nanoTime();
        }

        public double stop() {
            return (System.nanoTime() - start) / 1e9;
        }
    }

    public static void sequentialMapEach(int[] data,
            IntUnaryOperator fun) {
        for (int i = 0; i < data.length; i++) {
            data[i] = fun.applyAsInt(data[i]);
        }
    }

    public static void parallelMapEach(int[] data,
            IntUnaryOperator fun) {
        ForkJoinPool pool = new ForkJoinPool();
        MapEachAction action = new MapEachAction(0,
                data.length, data, fun);
        pool.invoke(action);
    }

    public static int[] makeConstantValueArray(int n,
            int k) {
        int[] result = new int[n];
        Arrays.fill(result, k);
        return result;
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        final int n = 5_000;
        int[] as = makeConstantValueArray(n, 30);
        int[] ap = makeConstantValueArray(n, 30);
        Timer t = new Timer();
        double ts, tp, sp;

        t.start();
        sequentialMapEach(as, MapEach::fibo);
        ts = t.stop();

        t.start();
        parallelMapEach(ap, MapEach::fibo);
        tp = t.stop();

        sp = ts / tp;

        // System.out.println(Arrays.toString(as));
        System.out.printf("Ts = %.2f seg.%n", ts);
        System.out.printf("Tp = %.2f seg.%n", tp);
        System.out.printf("Sp = Ts/Tp = %.4f seg.%n", sp);
        System.out.printf("Arreglos iguales = %b%n",
                Arrays.compare(as, ap) == 0);
    }
}