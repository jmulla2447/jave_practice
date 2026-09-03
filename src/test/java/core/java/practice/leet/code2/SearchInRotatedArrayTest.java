package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedArrayTest {

    @Test
    void searchInRotatedArray() {
        SearchInRotatedArray rotatedArray  =  new SearchInRotatedArray();
        int actualIndex = rotatedArray.search(new int[]{4,5,6,7,0,1,2}, 0);
        assertEquals(4,actualIndex);
    }

    @Test
    void searchInRotatedArray1() {
        SearchInRotatedArray rotatedArray  =  new SearchInRotatedArray();
        int actualIndex = rotatedArray.search(new int[]{4,5,6,7,0,1,2}, 3);
        assertEquals(-1,actualIndex);
    }

    @Test
    void searchInRotatedArray2() {
        SearchInRotatedArray rotatedArray  =  new SearchInRotatedArray();
        int actualIndex = rotatedArray.search(new int[]{4}, 0);
        assertEquals(-1,actualIndex);
    }

    @Test
    void findMin() {
        SearchInRotatedArray rotatedArray  =  new SearchInRotatedArray();
        int actualMin = rotatedArray.findMin(new int[]{4,5,6,7,0,1,2});
        assertEquals(0, actualMin);
    }

    @Test
    void findMin1() {
        SearchInRotatedArray rotatedArray  =  new SearchInRotatedArray();
        int actualMin = rotatedArray.findMin(new int[]{5,6,7,0,1,2, 4});
        assertEquals(0, actualMin);
    }
}
