package core.java.practice.leet.code2;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {

    private List<Integer> jumpHistory = new ArrayList<>();

    public boolean canJump(int[] nums) {
        boolean isPossible = false;
        for (int i = 0; (i < nums.length && !jumpHistory.contains(i) && !isPossible); i++) {
            if (nums[i] == 0) break;
            if (nums[i] >= nums.length - 1) {
                isPossible = true;
                break;
            }
            int j = i;
            while (nums[j] != 0) {
                jumpHistory.add(j);
                j = j + nums[j];
                if (j >= nums.length - 1) {
                    isPossible = true;
                    break;
                }
            }
        }
        return isPossible;
    }
}
