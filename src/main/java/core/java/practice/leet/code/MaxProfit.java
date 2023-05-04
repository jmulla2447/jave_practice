package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        AtomicInteger minP = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger maxP = new AtomicInteger(0);

        Arrays.stream(prices).forEach(p -> {
            if(p < minP.get()){
                minP.set(p);
            }else if (p - minP.get() > maxP.get() ){
                maxP.set(p - minP.get());
            }
        });
        return maxP.get();
    }
}