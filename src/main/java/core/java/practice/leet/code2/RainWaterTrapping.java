package core.java.practice.leet.code2;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class RainWaterTrapping {

    public int waterTrap(int[] a){
        int storage = 0;
        int imax =  0, jmax =  0;
        // Forward scan (i++)
        int i = advance(0, idx -> idx + 1 < a.length && a[idx] < a[idx + 1], idx -> idx + 1);

        // Backtrack scan (j--)
         int j = advance(a.length - 1, idx -> idx - 1 >= 0 && a[idx] < a[idx - 1], idx -> idx - 1);
        jmax = a[j];
        imax = a[i];
        while(i <j){
            if(a[i]> a[j]){
                jmax = Math.max(jmax, a[j]);
                storage +=  (jmax- a[j]);
                j--;
            }else{
                imax = Math.max(imax, a[i]);
                storage +=  (imax- a[i]);
                i++;
            }
        }
        return storage;
    }

    /**
     * Single higher-order function that executes any pointer traversal
     * based on passed lambda behaviors.
     */
    public static int advance(int start, IntPredicate condition, IntUnaryOperator step) {
        int index = start;
        while (condition.test(index)) {
            index = step.applyAsInt(index);
        }
        return index;
    }
}
