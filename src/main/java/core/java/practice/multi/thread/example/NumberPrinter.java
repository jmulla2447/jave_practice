package core.java.practice.multi.thread.example;

public class NumberPrinter implements Runnable {
    private Printer printer;
    private int maxNo;
    private int totalThreads;

    NumberPrinter(Printer printer, int maxNo, int totalThreads) {
        this.printer = printer;
        this.maxNo = maxNo;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        try {
            while (printer.getNo() <= maxNo) {
                synchronized (printer) {
                    int no = printer.getNo();
                    if (no % totalThreads == Thread.currentThread().getId() % totalThreads) {
                        printer.print(no);
                        no++;
                        printer.setNo(no);
                        printer.notifyAll();
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
