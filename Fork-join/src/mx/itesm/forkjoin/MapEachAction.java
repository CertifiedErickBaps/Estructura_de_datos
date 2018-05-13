package mx.itesm.forkjoin;

import java.util.concurrent.RecursiveAction;
import java.util.function.IntUnaryOperator;

@SuppressWarnings("serial")
public class MapEachAction extends RecursiveAction {

    public static final int LIMITE = 50;
    private int lo, hi;
    private int[] data;
    private IntUnaryOperator fun;

    public MapEachAction(int lo, int hi, int[] data,
            IntUnaryOperator fun) {
        this.lo = lo;
        this.hi = hi;
        this.data = data;
        this.fun = fun;
    }

    @Override
    protected void compute() {
        if (hi - lo < LIMITE) {
            for (int i = lo; i < hi; i++) {
                data[i] = fun.applyAsInt(data[i]);
            }
        } else {
            int mid = (lo + hi) / 2;
            MapEachAction a1 = new MapEachAction(lo, mid, data, fun);
            MapEachAction a2 = new MapEachAction(mid, hi, data, fun);
            invokeAll(a1, a2);    
        }
    }
}