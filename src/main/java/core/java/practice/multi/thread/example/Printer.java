package core.java.practice.multi.thread.example;

public class Printer {
    private int no;

    public Printer(int no){
        this.no = no;
    }

    public synchronized  int getNo() {
        return no;
    }

    public synchronized void setNo(int no) {
        this.no = no;
    }

    public void print() {
        System.out.println(Thread.currentThread().getName()+" :  "+no);
    }
}
