package core.java.practice.java21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessTest  implements Runnable{

    private Lock lock;
    private IntIncrement increment;

    public FairnessTest(Lock lock, IntIncrement increment){
        this.lock = lock;
        this.increment = increment;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread no %s enter in run block", Thread.currentThread().getName()));
        synchronized (lock){
            System.out.println(String.format("Thread no %s acquired lock", Thread.currentThread().getName()));
            increment.increment();
            System.out.println(String.format("Thread no %s before release lock", Thread.currentThread().getName()));
        }
        System.out.println(String.format("Thread no %s lock released.", Thread.currentThread().getName()));
    }

    public static void main(String[] args) throws InterruptedException {
       Lock lock1 = new ReentrantLock(true);
        IntIncrement IncrementCount = new IntIncrement(2l);
        for(int i = 0 ; i < 4; i++ ){
            new Thread(new FairnessTest(lock1, IncrementCount)).start();
        }
        Thread.sleep(15500l);
    }
}


class IntIncrement{
    private long count;
    IntIncrement(long count){
        this.count = count;
    }
    public long getCount(){
        return count;
    }

    public void increment(){
        this.count++;
    }
}
