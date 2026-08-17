package core.java.practice.java21.seq.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Print print = new Print();
        for(int i = 0 ; i < 19 ; i ++){
            new Thread(print, i+"").start();
        }
    }
}
