package core.java.practice.multi.thread.example;

import java.awt.print.PrinterException;

public class OddPrinter implements Runnable {
    private Printer printer;
    private int maxNo;

    OddPrinter(Printer printer, int maxNo) {
        this.printer = printer;
        this.maxNo = maxNo;
    }


    @Override
    public void run() {
        try {

            while (printer.getNo() < maxNo) {
                synchronized (printer) {
                    if (printer.getNo() % 2 == 1) {
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
