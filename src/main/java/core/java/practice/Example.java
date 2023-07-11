package core.java.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Example {

    /*
    * [3,4,5,1,-1,6,7,8,2]
    * Print all pairs (a, b) , when  a+b=7, eg. (3,4), (6,1), etc
    * 7-3 =4
    * Write a Java function which print all pairs (a, b) , when  a+b=7, eg. (3,4), (6,1), etc
    * */

    public static void  gerPair(int[] arr, int target){//[3,4,5,1,-1,6,7,8,2]   7
        Map<Integer, Integer> findMatch = new LinkedHashMap<>();

        for(int i = 0 ; i < arr.length ;i++){  //3 7   5  1
            int res =  target -  arr[i];// 3  2
            if(findMatch.keySet().contains(res)){
                System.out.println(i+" :  "+ findMatch.get(res));
            }else {
                findMatch.put(arr[i], i); //  3, 0  , 2,2
            }
        }
    }

    public static void  gerPair1(int[] arr, int target){//[3,4,5,1,-1,6,7,8,2]   7
       for(int i = 0, j =  i+1 ; i< arr.length; i++){
           if(arr[i]  + arr [j] == target);
       }
    }


    public static void main(String[] args) {
        int[] a =  {3,4,5,1,-1,6,7,8,2};
        gerPair(a, 7);
    }


}
