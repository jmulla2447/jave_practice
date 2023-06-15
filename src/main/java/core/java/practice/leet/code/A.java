package core.java.practice.leet.code;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class Solution {
    public int[] solution(int[] A) {
        // Implement your solution here
        int min = 0 , max = 0 , countOfDuplicate = 0;
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for(int i : A){
            if(uniqueSet.contains(i)){
                countOfDuplicate++;
                if(min> i){
                    min = i ;
                }
                if(max < i ){
                    max = i;
                }
            }else{
                uniqueSet.add(i);
            }
        }
        int[] result =  new int[uniqueSet.size()+3];
        result[0] =  countOfDuplicate;
        result[1] = min;
        result[2] = max;
        System.arraycopy(uniqueSet.toArray(), 0, result,2, uniqueSet.size() );
        return result;
    }
}
