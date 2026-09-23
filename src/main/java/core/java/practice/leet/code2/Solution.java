package core.java.practice.leet.code2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int totalClimbWays;
    private int[] stepsJump = {1,2};
    public int climbStairs(int n) {
        doClimbing(0, n, new ArrayDeque<>());
        return totalClimbWays;
    }


    public void doClimbing(int jump, int target, ArrayDeque<Integer> stack){
        if(target==0){
            totalClimbWays++;
            return;
        }else if (target < 0 ){
            return;
        }

        for(int i =  0 ; i < stepsJump.length; i++){
            stack.push(stepsJump[i]);
            doClimbing(stepsJump[i], target -stepsJump[i], stack);
            stack.pop();
        }
    }

}
