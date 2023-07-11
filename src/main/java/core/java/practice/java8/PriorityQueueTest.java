package core.java.practice.java8;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    private  static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) {
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(9);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(7);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }
}
