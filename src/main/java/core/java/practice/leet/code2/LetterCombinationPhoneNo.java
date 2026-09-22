package core.java.practice.leet.code2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/*
* Problem Description

You are given a string containing digits from 2 to 9 inclusive. Your task is to return all possible letter combinations that the number could represent, similar to how letters are mapped on a telephone keypad.

The digit-to-letter mapping follows the traditional phone keypad layout:

2 maps to "abc"
3 maps to "def"
4 maps to "ghi"
5 maps to "jkl"
6 maps to "mno"
7 maps to "pqrs"
8 maps to "tuv"
9 maps to "wxyz"
Note that the digit 1 does not map to any letters.

For example:

If the input is "23", you need to combine all letters from digit 2 ("abc") with all letters from digit 3 ("def"), resulting in ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
If the input is an empty string, return an empty list [].
The answer can be returned in any order.

The solution uses an iterative approach where it processes each digit one by one. Starting with an initial list containing an empty string, it iterates through each digit in the input. For each digit, it looks up the corresponding letters and creates new combinations by appending each letter to all existing combinations. The process continues until all digits have been processed, building up the complete set of letter combinations.
* */
public class LetterCombinationPhoneNo {
    private Deque<String> stack = new ArrayDeque<>();
    private final static Map<Integer, String> phoneNoMap = Map.of(2, "ABC", 3, "DEF", 4, "GHI", 5, "JKL", 6, "MNO", 7, "PQR", 8, "STU", 9 , "WXYZ");

    public List<String> letterCombination(String digit){

        if(digit.isEmpty()) return List.of();
        stack.push("");
        for (int i = 0; i < digit.length(); i++) {
            createCombination(phoneNoMap.get(digit.charAt(i) - '0'), stack);
        }
        return stack.stream().toList();
    }

    private void createCombination(String s, Deque<String> stack){
        if(s.isBlank()) {
            stack.pop();
            return;
        }

        var element = stack.peek();
        var splitedString = SplitString.split(s);
        createCombination(splitedString.remaingChar(), stack);
        stack.push(element+splitedString.lastChar());
    }

    record SplitString(String lastChar, String remaingChar){
        public static SplitString split(String digit){
            if(digit.isBlank()){
                new SplitString("","");
            }
            return new SplitString(digit.substring(digit.length()-1), digit.substring(0, digit.length()-1));
        }
    }
}
