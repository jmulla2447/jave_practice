package core.java.practice.multi.thread;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Consumer implements Runnable{

    private Bank bank;
    private int time;

    private  Random random = new Random();


    Consumer(Bank bank, int time){
        this.bank = bank;
        this.time = time;
    }
    @Override
    public void run() {
        int randomNumber = random.nextInt(5001) + 1000;
        try {
            for (int i = 0; i <= time; i++) {
                System.out.println(Thread.currentThread().getName()+"("+randomNumber+") balance money :"+bank.getBalance());
                Thread.sleep(randomNumber);
                System.out.println(Thread.currentThread().getName()+"("+randomNumber+") withdrow money : 20");
                bank.withdraw(20);
                Thread.sleep(randomNumber);
                System.out.println(Thread.currentThread().getName()+"("+randomNumber+") balance money :"+bank.getBalance());
            }
        }catch (InterruptedException ex){
           ex.printStackTrace();
        }
    }
}
