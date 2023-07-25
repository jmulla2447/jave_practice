import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Parth {

    static LinkedList<Character> stack = new LinkedList<>();
    static Set<Character> rightBreak = new HashSet<>();
    static Set<Character> leftBreak = new HashSet<>();

    static {
        rightBreak.add('(');
        rightBreak.add('[');
        rightBreak.add('{');
        leftBreak.add(')');
        leftBreak.add(']');
        leftBreak.add('}');
    }

    public static boolean isValid(String str) {
        char[] tokens = str.toCharArray();
        for (char token : tokens) {
            if (rightBreak.contains(token)) {
                stack.push(token);
            }
            if (leftBreak.contains(token)) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]}{}[]"));
    }
}
