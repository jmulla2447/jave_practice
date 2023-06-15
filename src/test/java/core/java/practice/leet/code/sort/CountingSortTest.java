package core.java.practice.leet.code.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @Test
    void sort() {

        CountingSort sort = new CountingSort();
        int[] a = {1,5,3,2,5,1,5,6,2,8};
        int[] result  = sort.sort(a);
        System.out.println(result);
    }
}
