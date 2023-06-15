package core.java.practice.leet.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BalancedBrecket {
    private static Map<Character, Character> brecketMap = new HashMap<>();

    static {
        brecketMap.put('[', ']');
        brecketMap.put('{', '}');
        brecketMap.put('(', ')');
    }

    public boolean isBreaketBalanced(String exp) {
        if(exp.length()%2!=0) return false;
        LinkedList<Character> stack = new LinkedList<>();
        char[] tokens = exp.toCharArray();
        for (char token : tokens) {
            if (brecketMap.keySet().contains(token)) {
                stack.push(token);
                continue;
            }
            if(stack.isEmpty() || token !=  brecketMap.get(stack.pop())){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
