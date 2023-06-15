package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestPositiveTest {

    @Test
    void solution() {
       int[] A =  {1, 3, 6, 4, 1, 2};
       SmallestPositive smallestPositive = new SmallestPositive();
       int a  =  smallestPositive.solution(A);
       System.out.println(a);
    }
}
