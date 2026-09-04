package core.java.practice.leet.code2;

import org.jetbrains.annotations.NotNull;

public class MiedianOf2SortedArray {

    @NotNull
    private static Result getResult(int[] a, int[] b, int totalLen) {
        int alen = a.length;
        int blen = b.length;
        int mid = totalLen / 2;
        if (alen < blen && alen < mid) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int left = mid;
        int right = totalLen - mid;
        Result result = new Result(left, right, a, b);
        return result;
    }

    public float meidan(int[] a, int[] b) {

        //1. Find left and right side of element required for median
        int toalLen = (a.length + b.length);
        Result result = getResult(a, b, toalLen);

        //cut partition

        return cutPartion(result, toalLen % 2 == 0);

    }

    private float cutPartion(Result result, boolean isEven) {
        int left = result.left();
        int right = result.right();
        int[] a = result.a();
        int alen = a.length;
        int[] b = result.b();
        int blen = b.length;
        int aCut = (a.length / 2);
        int bCut = left - aCut;
        int newCut = -5;
        do {
            if (newCut != -5) {
                aCut = (a.length / 2) + newCut;
                bCut = left - aCut;
            }
            newCut = requiredRecut(a[aCut-1], b[bCut ], b[bCut-1], a[aCut] );

        } while (newCut != 0);

        if (isEven) {
            return (float) (a[aCut-1] + b[bCut-1]) / 2;
        } else {
            if (a[aCut-1] < b[bCut]) {
                return b[bCut];
            } else {
                return a[aCut-1];
            }
        }

    }

    private int requiredRecut(int a1, int b2, int b1, int a2) {
        if (a1 > b2) return -1;
        else if (b1 > a2) return 1;
        return 0;
    }

    private record Result(int left, int right, int[] a, int[] b) {
    }


}
