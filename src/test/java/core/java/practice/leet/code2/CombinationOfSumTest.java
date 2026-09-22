package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationOfSumTest {

    @Test
    void combinationSum() {
        CombinationOfSum sum = new CombinationOfSum();
        var result = sum.combinationSum(new int[]{2,3,6,7}, 7);
        assertEquals(2, result.size());
    }
}
