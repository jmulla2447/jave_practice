package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        //find smallest and mulitply with heights.len
        //check higest one and pre or next
        int largest = 0, smallest = 0, largestPre = 0, largestNext = 0;
        int histogram = 0;
        for (int i = 0; i < heights.length; i++) {
            largestPre = 0;
            largestNext = 0;
            if (i == 0 || smallest > heights[i]) {
                smallest = heights[i];
            }
            if (i == 0) largest = heights[i];
            if (largest < heights[i]) {
                largest = heights[i];
                if (i != 0) {
                    largestPre = heights[i - 1];
                }
                if (i != heights.length - 1) {
                    largestNext = heights[i + 1];
                }
                if (largestPre > largest && largestNext > largest) {
                    continue;
                }
                histogram = Math.max(largestPre, largestNext) * 2;
            }

        }
        if (histogram == 0) histogram = largest;
        return Math.max(histogram, (smallest * heights.length));
    }


    public int largestRectangleArea1(int[] heights) {
        //find smallest and mulitply with heights.len
        //check higest one and pre or next
        int largest = 0, smallest = 0, largestPre = 0, largestNext = 0;
        int histogram = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            largestPre = 0;
            largestNext = 0;
            if (i == 0 || smallest > heights[i]) {
                smallest = heights[i];
            }
            if (i == 0) largest = heights[i];
            if (largest < heights[i]) {
                stack.push(heights[i]);
                largest = heights[i];
            } else {
                int j = 1;
                int ele = stack.peek();
                while (!stack.isEmpty() || ele > heights[i]) {
                    histogram = Math.max(histogram, stack.pop() * j);
                    j++;
                }
                stack.push(heights[i]);
                largest = stack.isEmpty() ? heights[i] : ele;
            }
        }

        //check end of the stack
        while (!stack.isEmpty()) {
            int ele = stack.pop();
            histogram = Math.max(histogram, ele * (heights.length - stack.size()));
        }

        if (histogram == 0) histogram = largest;
        return Math.max(histogram, (smallest * heights.length));
    }
}
