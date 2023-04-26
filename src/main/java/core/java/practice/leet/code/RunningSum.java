package core.java.practice.leet.code;

import core.java.practice.performance.ComplexityCalulationUtil;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/*
* Running Sum of 1d Array
* Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
* */
public class RunningSum implements Runnable{

    private int[] intputs = {3,1,2,10,1};

    /* recursive approach
    *  Find first base case and recursive case
    *  Time complexity find by based on tree depth that is define by no of elements o(n)
    *  Space complexity is find by if you use new arrray to store the result.  o(n)
    * */


    public void runningArrayRecursively(int [] nums, int element , int [] result ){
        if(element == 0 ){
            result[element] = nums[element];
        }else {
            result[element] = result[element-1] + nums[element];
            if(nums.length == element+1) return ;
        }
        runningArrayRecursively(nums, element+1 ,result);
    }

    public int[] runningSumStream(int[] nums) {
        AtomicInteger sum = new AtomicInteger();
        return Arrays.stream(nums)
                .map(i -> sum.addAndGet(i))
                .toArray();
    }

    public int[] runningSumBestSolution(int[] nums) {
        Arrays.parallelPrefix(nums, (a, b) -> a + b);
        return nums;
    }

    public static void main(String[] args) {
        ComplexityCalulationUtil.calculateComplexity(new RunningSum(), 10000000);
    }

    @Override
    public void run() {
        runningSumStream(intputs);
        runningSumBestSolution(intputs);
    }
}
