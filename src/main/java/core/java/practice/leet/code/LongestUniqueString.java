package core.java.practice.leet.code;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueString {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> uni = new HashSet<>();
        int longest = 0;
        char[] a =  s.toCharArray();
        int len = a.length;
        for (int i = 0, j = i + 1; i < len - 1; i++) {
            uni.add(a[i]);
            while (uni.add(a[j])) {
                j++;
            }
            i = j;
            j = i + 1;
            longest = Math.max(longest, uni.size());

            if (len - longest < longest) break;
        }
        return uni.size();
    }
}
