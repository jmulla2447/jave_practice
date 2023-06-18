package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {

    @Test
    void largestRectangleArea() {
        int[] a = {2,1,5,6,2,3};
        LargestRectangleInHistogram histogram =  new LargestRectangleInHistogram();
        int result  =  histogram.largestRectangleArea(a);
        System.out.println(result);

        a = new int[]{2, 4};
         histogram =  new LargestRectangleInHistogram();
         result  =  histogram.largestRectangleArea(a);
        System.out.println(result);
    }
}
