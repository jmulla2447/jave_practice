package core.java.practice.multi.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeCounter {
    private int count = 0;


    public synchronized void increment() {
        count++;
    }

    public synchronized   int getCount() {
        return count;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new Worker(new ThreadSafeCounter()));

    }
}

class Worker implements Runnable{
    ThreadSafeCounter counter;
    Worker(ThreadSafeCounter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        synchronized (counter){
            counter.increment();
        }

    }
}
