package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EvaluateReversePolishNotation {

    private final static List<String> op = Arrays.asList("+", "-", "/", "*");

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0 || tokens == null) return 0;
        LinkedList<Integer> intStack = new LinkedList<>();
        for (String token : tokens) {
            if (op.contains(token)) {
                intStack.push(performOpration(token, intStack));
            } else {
                intStack.push(Integer.parseInt(token));
            }
        }
        return intStack.pop();
    }

    private Integer performOpration(String token, LinkedList<Integer> intStack) {
        int a, b;
        switch (token) {
            case "+":
                return intStack.pop() + intStack.pop();
            case "-":
                return intStack.pop() - intStack.pop();
            case "/":
                a = intStack.pop();
                b = intStack.pop();
                return b / a;
            case "*":
                a = intStack.pop();
                b = intStack.pop();
                return a * b;
        }
        return null;
    }
}
