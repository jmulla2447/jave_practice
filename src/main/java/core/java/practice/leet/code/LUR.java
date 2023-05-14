package core.java.practice.leet.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LUR {

    private int cap;

    LinkedList<Integer> queue;

    HashSet<Integer> checkUnique;

    public LUR(int cap) {
        this.cap = cap;
        int hasCap = (int) (cap * (0.75));
        queue = new LinkedList<>();
        checkUnique = new HashSet<>(hasCap);
    }

    public void addCache(int val) {
        if(cap ==  getSize()){
          int last =  queue.removeLast();
          checkUnique.remove(last);
        }
        if (!checkUnique.add(val)) {
            queue.remove(val);
        }
        queue.push(val);
    }

    public int getSize(){
        return queue.size();
    }

    public void display(){
        queue.stream().forEach(System.out::println);
    }


}
