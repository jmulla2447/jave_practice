package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestNonRepetativeStringTest {

    @Test
    void lengthLongestString() {
        LongestNonRepetativeString longestNonRepetativeString = new LongestNonRepetativeString();
        assertEquals (4,longestNonRepetativeString.lengthLongestString("abcbcdaacb"));
    }



}
