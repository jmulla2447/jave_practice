package core.java.practice.multi.thread.pc;

import core.java.practice.java21.seq.print.Print;
import core.java.practice.multi.thread.example.Printer;

public class Producer extends Thread {

    Printer print;

    Producer(Printer print){
        this.print = print;
    }

    @Override
    public void run() {
        try {
            while(print.getNo() %2 == 0){
                wait();
            }

            if(print.getNo()%2 !=  0){
                print.print();
                print.setNo(print.getNo()+1);
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Printer printer =  new Printer(1);
        Producer producer =  new Producer(printer);
        Consumer consumer = new Consumer(printer);
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
