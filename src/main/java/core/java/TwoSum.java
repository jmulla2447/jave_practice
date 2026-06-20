package core.java;

import java.util.HashMap;
import java.util.ArrayList;

public class TwoSum {
    public ArrayList<Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(map.get(complement));
                result.add(i);
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        ArrayList<Integer> result = twoSum.twoSum(nums, target);
        System.out.println(result); // Output: [0, 1]
    }

}
