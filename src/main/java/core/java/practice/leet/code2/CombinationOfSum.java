package core.java.practice.leet.code2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

* */

public class CombinationOfSum {

    private List<ArrayDeque<Integer>> result = new ArrayList<>();

    public List<ArrayDeque<Integer>> combinationSum(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {
            var listOfInt = new ArrayDeque<Integer>();
            listOfInt.push(nums[i]);
            getCombination(i, nums, listOfInt, target - nums[i]);

        }

        return result;
    }

    private void getCombination(int idx, int[] nums, ArrayDeque<Integer> listOfInt, int target) {

        if (target == 0) { // find combiation return list
            result.add(listOfInt.clone());
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            listOfInt.push(nums[i]);
            //choose same element for next choise
            getCombination(i, nums, listOfInt, target - nums[i]);
            //Backtrack logic
            listOfInt.pop();
        }
    }


}
