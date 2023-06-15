package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowSortedArrayMedianTest {

    @Test
    void swapBasedOnSmallFirst() {
        int[] a = {1,2,3,4};
        int[] b = {1,2,3,4,5,6};
        TowSortedArrayMedian arrayMedian = new TowSortedArrayMedian();
        arrayMedian.swapBasedOnSmallFirst(a, b );
        System.out.println(a.length);
    }
}
