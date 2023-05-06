package core.java.practice.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }
    public int longestPalindrome(String s) {
        char[] tokens = s.toCharArray();
        int longestPalindrome = 0;
        Integer charCont = null, maxOddNo = 0;
        Map<Character, Integer> map = mapCharCount(tokens);
        Set<Character> keySets = map.keySet();
        for (Character key : keySets) {
            charCont = map.get(key);
            if (charCont % 2 == 0) {
                longestPalindrome += charCont;
            } else {
                if(maxOddNo < charCont){
                    maxOddNo =  charCont;
                }
            }
        }
        return longestPalindrome+ maxOddNo;
    }

    public Map<Character, Integer> mapCharCount(char[] tokens) {
        int len = tokens.length;
        Map<Character, Integer> mapCharCounter = new HashMap<>();
        for (char c : tokens) {
            Integer key = mapCharCounter.get(c);
            if (key == null) {
                mapCharCounter.put(c, 1);
            } else {
                mapCharCounter.put(c, ++key);
            }
        }
        /**  Using Steam api
         * public int longestPalindrome(String s) {
         *         Map<Character, Long> mapCharCounter = s.chars()
         *                 .mapToObj(c -> (char) c)
         *                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         *         int longestPalindrome = 0;
         *         Long charCont = null, maxOddNo = Long.valueOf(0);
         *         Set<Character> keySets = mapCharCounter.keySet();
         *         for (Character key : keySets) {
         *             charCont = mapCharCounter.get(key);
         *             if (charCont % 2 == 0) {
         *                 longestPalindrome += charCont;
         *             } else {
         *                 if(maxOddNo < charCont){
         *                     maxOddNo =  charCont;
         *                 }
         *             }
         *         }
         *         return (int)(longestPalindrome+ maxOddNo);
         *     }
         */

        return mapCharCounter;
    }
}
