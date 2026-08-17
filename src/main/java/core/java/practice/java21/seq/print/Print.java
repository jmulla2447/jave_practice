package core.java.practice.java21.seq.print;

public class Print implements Runnable{

    private long nextTrun = 1 ;
    public void print(){
        System.out.println(String.format("Print Thread no %s", Thread.currentThread().getName()));
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (nextTrun != Long.parseLong(Thread.currentThread().getName())) {
                    this.wait();
                }
                print();
                nextTrun++;
                notifyAll();
            }
        } catch (InterruptedException e) {
            notifyAll();
        }
    }
}
