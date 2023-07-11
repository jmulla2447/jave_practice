package core.java.practice.leet.code;

public class FindRotationArray {

    public int findMin(int[] n) {
        int mid = 0;
        int len = n.length - 1;

        for (int i = 0, j = len; i < j; ) {

            mid = ((int) (i + j) / 2);
            System.out.println(mid);
            if (n[mid - 1] <= n[mid] && n[mid] <= n[mid + 1]) {// 2 3 4 5 1
                return mid;
            } else if (n[mid - 1] >= n[mid]) {
                j = mid;
                i++;
            } else {
                i = mid;
                j--;
            }
        }
        throw new IllegalArgumentException("Data is not proper");
    }
}
