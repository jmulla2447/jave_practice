package core.java.practice.leet.code2;

import javax.management.openmbean.CompositeType;
import java.util.HashSet;
import java.util.Set;

public class LongestNonRepetativeString{

    private Set<Character> unique = new HashSet<>();
    private int max =  0;
    public int lengthLongestString(String str){// ab c bcdabcd
        char[] tokens = str.toCharArray();
        for(int i= 0 , j = i+1; j<= tokens.length-1; ){

            if( unique.isEmpty()) unique.add(tokens[i]); // b
            if(!unique.contains(tokens[j]) ){
                unique.add(tokens[j]);
            }else {
                if(max < (j-i)) {
                    max = (j-i);
                }
                if(max>(tokens.length-1-j)){
                    break;
                }
                unique = new HashSet<>();
                i = j;
            }
            j++;
        }
        return max;
    }
}
