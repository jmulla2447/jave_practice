package core.java.practice.multi.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void getBalance() throws InterruptedException {
        Bank bank = new Bank(100);
        Consumer c =  new Consumer(bank, 5);
        Consumer c1 =  new Consumer(bank, 5);
        Producer p =  new Producer(bank, 2);
        Thread wife1 = new Thread(c, "wife1");
        Thread wife2 = new Thread(c1, "wife2");
        Thread husband = new Thread(p);
        wife1.start();
        wife2.start();
        husband.start();
        Thread.currentThread().join();

    }

    @Test
    void deposit() {
    }

    @Test
    void withdraw() {
    }
}
