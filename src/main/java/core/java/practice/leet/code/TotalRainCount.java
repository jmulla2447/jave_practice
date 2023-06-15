package core.java.practice.leet.code;

import java.util.Arrays;

public class TotalRainCount {
    public int trap(int[] height) {
        int[] result = removeUnwantedWall(height);
        if (result.length <= 2) return 0;
        int totalRainStorage = 0;
        for (int i = 0, j = i + 1; j < result.length-1; i++) {
            while (result[i] > result[j]) {
                if(j > result.length-1) break;
                totalRainStorage += result[i] - result[j];
                j++;
            }
            i = j - 1;
            j++;
        }
        return totalRainStorage;
    }

    public int[] removeUnwantedWall(int[] height) {
        int intIndex = 0, endIndex = height.length - 1;
        boolean iflag = false, jflag = false;
        int i = 0, j = height.length - 1;
        while ((i < j) && (!iflag || !jflag)) {
            if (height[i] < height[i + 1]) {
                intIndex = i + 1;
                i++;
            } else {
                iflag = true;
            }
            if (height[j - 1] > height[j]) {
                endIndex = j - 1;
                j--;
            } else {
                jflag = true;
            }
        }

        if(endIndex == intIndex) return new int[0];
        int[] result = Arrays.copyOfRange(height, intIndex,endIndex+1);
        return result;
    }
}
