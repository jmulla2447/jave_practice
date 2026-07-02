package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeativeCharTest {

    @Test
    void getFirstNonRepative() {
        FirstNonRepeativeChar nonRepeativeChar = new FirstNonRepeativeChar();
        String s = "geeksforgeeks";
       // Output: 'f'

        assertEquals(nonRepeativeChar.getFirstNonRepative(s), 'f');
    }

    @Test
    void getFirstNonRepative1() {
        FirstNonRepeativeChar nonRepeativeChar = new FirstNonRepeativeChar();

        String s = "racecar" ;
        //      Output: 'e'
        assertEquals(nonRepeativeChar.getFirstNonRepative(s), 'e');
    }

    @Test
    void getFirstNonRepativ2e() {
        FirstNonRepeativeChar nonRepeativeChar = new FirstNonRepeativeChar();

        String s =  "aabbccc";
        assertNull(nonRepeativeChar.getFirstNonRepative(s) );
    }
}
