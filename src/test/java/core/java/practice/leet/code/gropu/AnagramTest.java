package core.java.practice.leet.code.gropu;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagrams() {

        Anagram anagram = new Anagram();
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> map = anagram.groupAnagrams(str);
        System.out.println(map);
    }
}
