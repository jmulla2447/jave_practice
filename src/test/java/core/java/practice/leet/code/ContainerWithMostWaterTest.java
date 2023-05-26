package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    public void maxContainerWIthWater() {
        int[] height = {1,8,3,5,4,6,8,5};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int maxWater  = containerWithMostWater.maxContainerWIthWater(height);
        assertEquals(40, maxWater);
    }
}
