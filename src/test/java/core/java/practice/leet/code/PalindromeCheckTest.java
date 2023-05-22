package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {
    PalindromeCheck  check = new PalindromeCheck();

    @Test
    void isPalindromeCheckNegativeNo() {
        int no = -121;
        assertEquals(false, check.isPalindrome(no));
    }

    @Test
    void isPalindromeValidateLast0() {
        int no = 120;
        assertEquals(false, check.isPalindrome(no));
    }
    @Test
    void isPalindromeCheckNonPalindromNo() {
        int no  = 123;
        assertEquals(false, check.isPalindrome(no));
    }
    @Test
    void isPalindrome() {
        int no = 1221;
        assertEquals(false, check.isPalindrome(no));
    }


    @Test
    void isPalindromeString() {
        String no = "1221";
        assertEquals(true, check.isPalindrome(no));
         no = "12321";
        assertEquals(true, check.isPalindrome(no));
    }

    @Test
    void isNoPalindromeCheck() {
        String no = "1233";
        assertEquals(false, check.isPalindrome(no));
    }


}
