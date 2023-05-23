package core.java.practice.multi.thread;

public class Producer implements Runnable {
    final private Bank bank;
    final private int time;

    Producer(Bank bank, int time){
        this.bank = bank;
        this.time = time;
    }
    @Override
    public void run() {
            for (int i = 0; i <= time; i++) {
                System.out.println(bank.deposit(20));
            }
    }
}
