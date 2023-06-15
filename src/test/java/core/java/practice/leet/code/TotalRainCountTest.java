package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

import static org.junit.jupiter.api.Assertions.*;

class TotalRainCountTest {

    @Test
    void trap() {
        TotalRainCount totalRainCount =  new TotalRainCount();
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int total  = totalRainCount.trap(a);
        System.out.println(total);

    }

    @Test
    void removeUnwantedWall() {

        TotalRainCount totalRainCount =  new TotalRainCount();
        int[] a = {1,2,3};
        int[] rsult = totalRainCount.removeUnwantedWall(a);
        System.out.println(rsult.length);


        a = new int[]{3,2,1};
        rsult = totalRainCount.removeUnwantedWall(a);
        System.out.println(rsult.length);

        a = new int[]{1,2,1,3,5,6,2,1};
        rsult = totalRainCount.removeUnwantedWall(a);
        System.out.println(rsult.length);
    }
}
