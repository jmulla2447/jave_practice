package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    @Test
    void push() {
        //actual
        CustomStack stack =  new CustomStack(3);
        //when
        stack.push(2);
        stack.push(1);
        stack.push(3);
        //assert
        assertEquals(3,stack.pop());
        assertEquals(1,stack.pop());
        assertEquals(2,stack.pop());
    }

    @Test
    void pop() {
        //actual

        //when

        //assert
    }
}
