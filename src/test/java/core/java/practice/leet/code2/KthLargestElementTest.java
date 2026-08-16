package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {

    @Test
    void findKthLargest() {
        KthLargestElement element = new KthLargestElement();
        int[] nums =  new int[]{3,2,1,5,6,4};
        int result = element.findKthLargest(nums,3);
        System.out.println(result);
    }


}
