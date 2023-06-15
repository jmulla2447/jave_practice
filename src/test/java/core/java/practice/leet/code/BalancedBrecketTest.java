package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBrecketTest {

    @Test
    void isBreaketBalanced() {
        BalancedBrecket balancedBrecket = new BalancedBrecket();
        boolean isBalnced = balancedBrecket.isBreaketBalanced("{[])}");
        System.out.println(isBalnced);
    }
}
