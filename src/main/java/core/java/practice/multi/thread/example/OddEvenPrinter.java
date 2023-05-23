package core.java.practice.multi.thread.example;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(1);  // Initialize the Printer object with the starting number
        int maxNumber = 20;

//        OddPrinter oddPrinter = new OddPrinter(printer, maxNumber);
//        EvenPrinter evenPrinter = new EvenPrinter(printer, maxNumber);
        NumberPrinter numberPrinter =  new NumberPrinter(printer,maxNumber,  3);

        Thread oddThread = new Thread(numberPrinter);
        Thread evenThread = new Thread(numberPrinter);
        Thread thirdThread = new Thread(numberPrinter);

        oddThread.start();
        evenThread.start();
        thirdThread.start();
    }
}
