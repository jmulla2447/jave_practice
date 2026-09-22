package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapyfyTest {

    @Test
    void add() {
        Heapyfy heapyfy  = new Heapyfy(6);
        heapyfy.add(11);
        heapyfy.add(21);
        heapyfy.add(1);
        heapyfy.add(8);

        heapyfy.displayHeap();
    }
}
