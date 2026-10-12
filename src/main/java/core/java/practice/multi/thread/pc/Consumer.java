package core.java.practice.multi.thread.pc;

import core.java.practice.multi.thread.example.Printer;

public class Consumer extends Thread {

    Printer print;

    Consumer(Printer print){
        this.print = print;
    }

    @Override
    public void run() {
        try {
        while(print.getNo() %2 != 0){
            wait();
        }

        if(print.getNo()%2 ==  0){
            print.print();
            print.setNo(print.getNo()+1);
            notifyAll();
        }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}