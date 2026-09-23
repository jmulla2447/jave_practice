package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RainWaterTrappingTest {

    @Test
    void waterTrap() {
        RainWaterTrapping trapping = new RainWaterTrapping();
        int actual = trapping.waterTrap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        assertEquals(6, actual);
    }

    @Test
    void waterTrap2() {
        RainWaterTrapping trapping = new RainWaterTrapping();
        int actual = trapping.waterTrap(new int[]{4,2,0,1,5,0,3,1,2});
        assertEquals(13, actual);
    }
}
