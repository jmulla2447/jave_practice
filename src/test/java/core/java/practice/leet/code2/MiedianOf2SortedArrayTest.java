package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiedianOf2SortedArrayTest {

    @Test
    public void meidan(){
        MiedianOf2SortedArray  array =  new MiedianOf2SortedArray();
        float acutla = array.meidan(new int[]{1,12,15,26,38}, new int[]{2,13,17,30,45,60});
        assertEquals(17.0f, acutla);
    }
}
