package core.java.practice.multi.thread.pc;

public class DeadLockAchive {
    public static void main(String[] args) {
        //achive dead lock situation
        Object r1 = new Object();
        Object r2 = new Object();
        Thread t1 = new Thread(() ->
        {
            synchronized (r1) {
                System.out.println("Thread 1: Locked r1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                synchronized (r2) {
                    System.out.println("Thread 1: Locked r2");
                }
            }
        }
        );
        Thread t2 = new Thread(() ->
        {
            synchronized (r2) {
                System.out.println("Thread 2: Locked r1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                synchronized (r1) {
                    System.out.println("Thread 2: Locked r2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
