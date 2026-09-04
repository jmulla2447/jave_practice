package core.java.practice.leet.code2;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] nums, int i, int j) {
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("  int arra , i " + i + ", j " + j);
        int temp;
        temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = new int[]{2, 9, 6, 8, 4, 5, 1, 7};
        int[] ans = sort.partion(nums, 0, nums.length - 1);
        Arrays.stream(ans).forEach(System.out::print);
        System.out.println();
    }

    public int[] partion(int[] nums, int start, int end) {
        if (nums.length <= 1) return nums;
        int pivotalIndex = getPivotPosition(nums, start, end);
        partion(nums, start, pivotalIndex - 1);
        partion(nums, pivotalIndex + 1, end);
        return nums;
    }

    public int getPivotPosition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1, j = 0;
        while (j <= end - 1) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }
        i++;
        swap(nums, i, end);
        return i;
    }
}
