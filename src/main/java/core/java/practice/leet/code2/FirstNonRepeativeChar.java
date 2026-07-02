package core.java.practice.leet.code2;

import core.java.practice.java8.Java8Practice;

import java.util.*;

public class FirstNonRepeativeChar {

    private HashMap<Character, Integer> freqMap = new HashMap<>();
    private Queue<Character> rightQueue  = new LinkedList<>();
    private Queue<Character> leftQueue  = new LinkedList<>();

    public Character getFirstNonRepative(String str){
        char[] c = str.toCharArray();
        for(int i = 0 , j = c.length-1; i <= j; i++, j-- ){
            if(i==j) {updateLeft(c[i],1,false);}
            else if(c[i] == c[j]){
                updateLeft(c[i],2,true);
            }else{
                updateLeft(c[i],1,false);
                updateRightQueue(c[j],1,false);
            }
        }
            return leftQueue.peek() == null ? rightQueue.peek() : leftQueue.peek();
    }

    private void updateLeft(char c, int count, boolean isReapeat){
        if(freqMap.keySet().contains(c)){
            freqMap.put(c,freqMap.get(c) + count);
            leftQueue.remove(c);
            rightQueue.remove(c);
        }else {
            if(isReapeat){
                freqMap.put(c,count);
            }else {
                freqMap.put(c,count);
                leftQueue.add(c);
            }
        }
    }


    private void updateRightQueue(char c,  int count, boolean isReapeat){
        if(freqMap.keySet().contains(c)){
            freqMap.put(c,freqMap.get(c) + count);
            leftQueue.remove(c);
            rightQueue.remove(c);
        }else {
            if(isReapeat){
                freqMap.put(c,count);
            }else {
                freqMap.put(c,count);
                rightQueue.add(c);
            }
        }
    }
}
