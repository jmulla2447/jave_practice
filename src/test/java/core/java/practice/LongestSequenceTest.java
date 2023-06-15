package core.java.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSequenceTest {

    @Test
    void longestConsecutive() {
        int[] nums = {100,4,200,1,3,2};
        LongestSequence sequence = new LongestSequence();
        System.out.println(sequence.longestConsecutive(nums));
    }
}
