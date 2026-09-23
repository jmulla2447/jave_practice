package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void doClimbing() {

        Solution solution = new Solution();
        int actual = solution.climbStairs(3);
        assertEquals(3, actual);
    }
}
