package core.java.practice.multi.thread.example;

public class Printer {
    private int no;

    Printer(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void print(int no) {
        System.out.println(Thread.currentThread().getName()+" :  "+no);
    }
}
