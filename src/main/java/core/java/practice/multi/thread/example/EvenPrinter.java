package core.java.practice.multi.thread.example;

public class EvenPrinter implements Runnable {
    private Printer printer;
    private int maxNo;

    EvenPrinter(Printer printer, int maxNo) {
        this.printer = printer;
        this.maxNo = maxNo;
    }


    @Override
    public void run() {
        try {
            while (printer.getNo() < maxNo) {
                synchronized (printer) {
                    if (printer.getNo() % 2 == 0) {//2= totalNoOfThread and 0 = threadid
                        int no = printer.getNo();
                        printer.print(no);
                        printer.setNo(++no);
                        printer.notify();
                    } else {
                        printer.wait();
                    }
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
