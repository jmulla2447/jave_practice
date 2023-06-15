package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    @Test
    void evalRPN() {
        EvaluateReversePolishNotation notation = new EvaluateReversePolishNotation();
        String[] tokens= {"4","13","5","/","+"};
        System.out.println(notation.evalRPN(tokens));

    }
}
