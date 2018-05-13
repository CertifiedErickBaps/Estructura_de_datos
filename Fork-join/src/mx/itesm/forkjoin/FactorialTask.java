package mx.itesm.forkjoin;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class FactorialTask
        extends RecursiveTask<BigInteger> {
    
    public static final int LIMITE = 1000;
    private int lo, hi;

    public FactorialTask(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    protected BigInteger compute() {
        if (hi - lo < LIMITE) {
            BigInteger resultado = BigInteger.ONE;
            for (int i = lo; i <= hi; i++) {
                resultado = resultado
                        .multiply(BigInteger.valueOf(i));
            }
            return resultado;
        } else {
            int mid = (hi + lo) / 2;
            FactorialTask t1 = new FactorialTask(lo, mid - 1);
            FactorialTask t2 = new FactorialTask(mid, hi);
            t1.fork(); // ejecuta en paralela
            BigInteger r1 = t2.compute();
            BigInteger r2 = t1.join();
            return r1.multiply(r2);
        }
    }
}