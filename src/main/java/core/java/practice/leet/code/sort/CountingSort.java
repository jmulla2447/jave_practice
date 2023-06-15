package core.java.practice.leet.code.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CountingSort {


    public int[] sort(int[] ele) {
        int[] countingArr = new int[(int) (ele.length * 1.5)];
        int count = 0;
        //counting
        for (int i : ele) {
            count = countingArr[i];
            countingArr[i] = ++count;
        }
      Arrays.stream(countingArr).forEach(System.out::print);
        System.out.println();
        List<Integer> arrange = new ArrayList<>();
        int value = 0;
        for (int i = 0, j = 1; i < countingArr.length; i++) {
            value = countingArr[i];
            while (j <= value) {
                arrange.add(i);
                j++;
            }
            j = 1;
        }
        return arrange.stream().peek(System.out::print).mapToInt(value1 -> value1).toArray();
    }
}
