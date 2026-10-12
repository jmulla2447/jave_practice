package core.java.practice.multi.thread;

import java.util.Random;
import java.util.random.RandomGenerator;

public class BankAccount {

    private int balance = 1000;

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrew " + amount
            );
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        BankAccount account  = new BankAccount();
      Person jack = new Person(account, "Jack", RandomGenerator.getDefault().nextInt(30));
      Person will = new Person(account, "Will", RandomGenerator.getDefault().nextInt(30));

    }
}


class Person extends Thread{
    private BankAccount bankAccount;
    private int amount;
    Person(BankAccount bankAccount, String name, int amout){
        super(name);
        this.bankAccount =  bankAccount;
        this.amount = amout;

    }

    @Override
    public void run() {
        synchronized (bankAccount) {
            if (amount < bankAccount.getBalance()) {
                bankAccount.withdraw(amount);
            }
        }
    }
}