package core.java.practice.leet.code;

public class ContainerWithMostWater {

    public int maxContainerWIthWater(int[] height) {
        int leftWall = 0;
        int rightWall = height.length-1;
        int maxWaterContained = 0;
        while (leftWall < rightWall) {
            maxWaterContained = Math.max(maxWaterContained, waterContained(height[leftWall], height[rightWall], Math.abs(rightWall - leftWall)));
            if (height[leftWall] < height[rightWall]) {
                leftWall++;
            } else {
                rightWall--;
            }
        }
        return maxWaterContained;
    }

    private int waterContained(int i, int j, int len) {
        return Math.min(i, j) * len;
    }
}
