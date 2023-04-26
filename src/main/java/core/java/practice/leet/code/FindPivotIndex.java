package core.java.practice.leet.code;

import java.util.Arrays;

/*
*724. Find Pivot Index
Easy
6.9K
744
Companies
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
* */
public class FindPivotIndex {

    public static int findPivotalIndex(int[] a){
        int totalSum =  a.length < 10000 ?  Arrays.stream(a).sum() : Arrays.stream(a).parallel().sum();
        int rSum  =  0 ;
        for(int i= 0 ; i < a.length; i++){
            if(rSum == totalSum - a[i] - rSum){
                return i;
            }
            rSum += a[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {1,7,3,6,5,6};
        System.out.println(findPivotalIndex(nums));
    }
}
/*
* While it is possible to use parallel streams to calculate the total sum of the array in parallel,
* it is not recommended in this case because it can actually slow down the execution due to the overhead of
* parallelization.

Here is an example of using parallel streams to calculate the total sum of the array in Java:


int totalSum = Arrays.stream(nums).parallel().sum();
However, it is important to note that parallel streams have additional overhead compared to regular streams,
* such as thread synchronization and data partitioning, which can actually slow down the execution for smaller
* arrays.

In general, parallel streams are most effective for large datasets where the cost of parallelization is outweighed
* by the potential speedup. For small arrays like the ones we're dealing with in this problem, it is better to
* stick with regular streams to avoid the overhead of parallelization.

Therefore, I recommend using regular streams as shown in my earlier implementations for this particular problem.
* */