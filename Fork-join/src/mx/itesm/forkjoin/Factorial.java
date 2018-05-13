package mx.itesm.forkjoin;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class Factorial {

    private static class Timer {
        private long start;

        public void start() {
            start = System.nanoTime();
        }

        public double stop() {
            return (System.nanoTime() - start) / 1e9;
        }
    }

    public static int sequentialFactorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        // System.out.println(resultado);
        return resultado.bitCount();
    }
    
    public static int parallelFactorial(int n) {
        ForkJoinPool pool = new ForkJoinPool();
        FactorialTask t = new FactorialTask(1, n);
        BigInteger resultado = pool.invoke(t);
        return resultado.bitCount();
    }

    public static void main(String[] args) {
        final int n = 300;
        Timer t = new Timer();
        double ts, tp, sp;
        int rs, rp;
        t.start();
        rs = sequentialFactorial(n);
        ts = t.stop();
        System.out.printf("Resultado secuencial = %d%n", rs);
        System.out.printf("Ts = %.2f seg.%n", ts);
        t.start();
        rp = parallelFactorial(n);
        tp = t.stop();
        System.out.printf("Resultado paralelo = %d%n", rp);
        System.out.printf("Tp = %.2f seg.%n", tp);
        
        sp = ts / tp;
        System.out.printf("Sp = Ts/Tp = %.4f%n", sp);
    }
}