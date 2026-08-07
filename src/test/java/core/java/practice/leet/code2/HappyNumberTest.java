package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    //@Test
    void isHappyNumber19() {
        HappyNumber obj = new HappyNumber();
        boolean actualHappy = obj.isHappyNumber(19);
        assertTrue(actualHappy);
    }


    @Test
    void isHappyNumber4() {
        HappyNumber obj = new HappyNumber();
        boolean actualHappy = obj.isHappyNumber(4);
        assertFalse(actualHappy);
    }
}
