package core.java.practice.leet.code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindPermutationPresentInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] findPer =  s2.toCharArray();
        Map<String, Long> frequencyMap = s1.codePoints()
                .mapToObj(Character::toString).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> validateMap ;
        int size = s1.length();
        for(int i= 0 ;  i<= findPer.length-size ;i++){
            if(frequencyMap.keySet().contains(findPer[i]+"")) {
                validateMap =  new HashMap<>(frequencyMap);
                if(isAnagram(validateMap, s2.substring(i,i+ size))){
                    return true;
                }
            }
        }
        return  false;
    }

    public boolean isAnagram(Map<String, Long> validateMap, String substring) {
        Map<String, Long> freqMap = substring.codePoints()
                .mapToObj(Character::toString).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return !(freqMap.keySet().stream().anyMatch(fr -> freqMap.get(fr) != validateMap.get(fr)));
    }

}
