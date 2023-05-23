package core.java.practice.multi.thread;

public class Bank {
    private int account;

    Bank(int account) {
        this.account = account;
    }

    public synchronized int getBalance() {
        return this.account;
    }

    public synchronized int deposit(int amt) {
        account = account + amt;
        return getBalance();
    }

    public synchronized int withdraw(int amt) {
        if(getBalance() <= 0) {
            System.out.println("Overdrawn Account");
            return getBalance();
        }
        account = account - amt;
        return getBalance();
    }
}
