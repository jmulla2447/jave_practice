package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindPermutationPresentInStringTest {

    @Test
    void checkInclusion() {
        Map<String,Long> validationMap =  new HashMap<>();
        validationMap.put("a",1l);
        validationMap.put("d",1l);
        validationMap.put("c",1l);
        FindPermutationPresentInString str  = new FindPermutationPresentInString();
        System.out.println(str.isAnagram(validationMap, "dcda"));
        System.out.println(str.isAnagram(validationMap, "aac"));
        System.out.println(str.isAnagram(validationMap, "aba"));
        System.out.println(str.isAnagram(validationMap, "cab"));
    }

    @Test
    void testCheckInclusion() {
        FindPermutationPresentInString str  = new FindPermutationPresentInString();
        assertTrue(str.checkInclusion("abcdxabcde", "abcdeabcdx"));
    }
}
