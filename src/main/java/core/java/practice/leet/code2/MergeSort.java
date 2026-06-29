package core.java.practice.leet.code2;

import java.util.Arrays;

public class MergeSort {

    public int[] divide(int [] num ){
        int len = num.length;

        if(len <= 1) return num;
        int mid = len/2;
        int[] leftNums =  new int[mid];
        int[] righttNums =  new int[len-mid];
        System.arraycopy(num,0,  leftNums, 0, mid);
        System.arraycopy(num,mid, righttNums , 0, len-mid);
        divide(leftNums);
        divide(righttNums);
        merge(leftNums,righttNums, num);

        return num;
    }

    public int[] merge(int[] left, int[] right , int[] num){
        int i = 0, j=0, k = 0;
        for(; i < left.length && j < right.length ; k++){
            if(left[i] < right [j]){
                num[k]= left[i];
                i++;
            }else{
                num[k] =  right[j];
                j++;
            }
        }
        while(i< left.length){
            num[k]= left[i];
            i++;
            k++;
        }
        while(j< right.length){
            num[k]= right[j];
            j++;
            k++;
        }
        return  num;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] ans = sort.divide(new int[]{2,9,6,8,4,5,1,7});
        Arrays.stream(ans).forEach(System.out::print);
        System.out.println();

    }
}
