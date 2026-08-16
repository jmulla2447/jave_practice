package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void partion() {
        QuickSort  sort = new QuickSort();
        int[] ans = sort.partion(new int[]{2,9,6,8,4,5,1,7}, 0, 8);
        assertArrayEquals(new int[] {1,2,4,5,6,7,8,9}, ans);
    }
}
