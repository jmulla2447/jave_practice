package core.java.practice.leet.code2;


import java.util.*;

/*
*
* Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

* */
public class KthLargestElement {
    private PriorityQueue<Integer>  kthQue = new PriorityQueue<>(Collections.reverseOrder());

    public int findKthLargest(int[] nums, int kth){
        int len  = nums.length-1;
        for(int i = 0, j = len ; i <j ;){

            if(nums[i]< nums[j]){
                kthQue.add(nums[i]);
                i++;
            }else {
                kthQue.add(nums[j]);
                j--;
            }

        }
        int i = 0;
        while(i<kth) {kthQue.poll();i++;}
        return  kthQue.peek();
    }
}
