package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    @Test
    void enqueue() {
        //actual
        CustomQueue queue = new CustomQueue(3);
        //when
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);

        //assertion
        assertEquals(queue.getSize(), 3);
    }

    @Test
    public void dequeueTest() {
        CustomQueue queue = new CustomQueue(3);
        //when
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        //assert
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(0, queue.dequeue());
    }

    @Test
    public void enqueueOverFlow() {
        //actual
        CustomQueue queue = new CustomQueue(2);
        //when
        queue.enqueue(1);
        queue.enqueue(2);

        //assertion
        assertThrows(IllegalArgumentException.class, () -> {
            queue.enqueue(3); // Adding the third element should throw an IllegalArgumentException
        });
    }

    @Test
    public void dequeueTestUnderFlow() {
        CustomQueue queue = new CustomQueue(3);
        //when
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        //assert
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertThrows(IllegalArgumentException.class,
                () -> queue.dequeue()
        );
    }

}
