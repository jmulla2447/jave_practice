package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void coinChange() {

        CoinChange change =  new CoinChange();
        int totalCoin = change.coinChange(new int[]{1,3,4,5}, 7);
        assertEquals(2, totalCoin);
    }
}
