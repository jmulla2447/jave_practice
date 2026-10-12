package core.java.practice.leet.code2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation1 {

    public List<List<Integer>> permute(int[] a) {
        var result = new LinkedList<List<Integer>>();
        getPermute(a, 0, result);
        return result;
    }

    public void getPermute(int[] a, int idx, LinkedList<List<Integer>> result) {
        if (idx == a.length - 1) {
            result.add(Arrays.stream(a).boxed().toList());
            return;
        }

        for (int i = idx; i < a.length; i++) {
            swap(idx, i, a);
            getPermute(a, idx + 1, result);
            backtract(idx, i, a);
        }
    }

    private void swap(int x, int y, int[] a) {
        var temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void backtract(int x, int y, int[] a) {
        swap(x, y, a);
    }


}
