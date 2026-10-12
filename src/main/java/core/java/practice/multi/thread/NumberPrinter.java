package core.java.practice.multi.thread;

public class NumberPrinter {

    public static void main(String[] args) {
        System.out.println("test");
        SharedNumber sharedNumber = new SharedNumber(1, 20);
        Thread oddPrinter = new Thread(new OddPrinter(sharedNumber));
        Thread evenPrinter = new Thread(new EvenPrinter(sharedNumber));
        oddPrinter.start();
        evenPrinter.start();
        try {
            oddPrinter.join();
            evenPrinter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SharedNumber {
    private final int max;
    private int i;

    SharedNumber(int i, int max) {
        this.i = i;
        this.max = max;
    }

    public synchronized void getOddNumber() throws InterruptedException {

        while (max > i) {
            while (max > i && i % 2 == 0) {
                wait();
            }
            if (i < max) {
                System.out.println(Thread.currentThread().getName() +" : "+ i);
                i = i + 1;
                notifyAll();

            }
        }

    }

    public synchronized void getEvenNumber() throws InterruptedException {

        while (max > i) {
            while (max > i && i % 2 != 0) {
                wait();
            }
            if (i < max) {
                System.out.println(Thread.currentThread().getName() +" : "+ i);
                i = i + 1;
                notifyAll();

            }
        }

    }

}

class OddPrinter implements Runnable {

    private final SharedNumber number;

    OddPrinter(SharedNumber sharedNumber) {
        number = sharedNumber;
    }

    @Override
    public void run() {
        try {
            number.getOddNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class EvenPrinter implements Runnable {

    private final SharedNumber number;

    EvenPrinter(SharedNumber sharedNumber) {
        number = sharedNumber;
    }

    @Override
    public void run() {
        try {
            number.getEvenNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}