package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRotationArrayTest {

    @Test
    void findMin() {
        FindRotationArray array =  new FindRotationArray();
        int ans = array.findMin(new int[]{4,5,6,7,0,1,2});
        System.out.println(ans);
    }
}
