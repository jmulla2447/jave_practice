package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.OptionalInt;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int product = Arrays.stream(nums).reduce((i, j) -> (j * i)).getAsInt();
        int[] result =  new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = product/nums[i];
        }
        return result;
    }
}
