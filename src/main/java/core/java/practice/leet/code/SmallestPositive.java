package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SmallestPositive {
    public int solution(int[] A) {
        // Implement your solution here

        Set<Integer> uni = new HashSet<>();
        int smallest = 1;
        for (int i = 0; i < A.length; i++) {
            if (smallest == A[i] || uni.contains(smallest)) {
                smallest = ++smallest;
                while (uni.contains(smallest)) {
                    smallest = ++smallest;
                }
            }
            uni.add(A[i]);
        }
        return smallest;
    }

    public static void main(String[] args) {

    }
}
