package core.java.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =  Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longest = 0 ;
        int b4, next ;
        for(int i : nums){
            int len = 0;
            if(set.remove(i)){
                len++;
                b4 = i-1;
                next = i+1;
                while( set.remove(b4)){
                    set.remove(b4);
                    len++;
                    b4 =b4-1;
                }
                while( set.contains(next)){
                    set.remove(next);
                    len++;
                    next=next+1;
                }
                longest = Math.max(longest, len);
                if(set.size() < longest) break;
            }
        }
        return longest;
    }
}
