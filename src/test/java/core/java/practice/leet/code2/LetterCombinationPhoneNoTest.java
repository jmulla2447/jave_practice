package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationPhoneNoTest {

    @Test
    void letterCombination() {
        LetterCombinationPhoneNo phoneNo = new LetterCombinationPhoneNo();
        List<String> combinations =  phoneNo.letterCombination("23");
        assertEquals(combinations.size(), 6);
    }
}
