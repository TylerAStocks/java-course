package concurrency;



class BankAccount {
    private int balance = 50;
    public int getBalance() {
        return balance;
    }

    public void withdraw(int balance) {
        this.balance -= balance;
    }
}


public class RaceCondition implements Runnable {
    
    private BankAccount acct = new BankAccount();
    public static void main(String[] args) {
        Runnable r = new RaceCondition();
        Thread john = new Thread(r);
        Thread mary = new Thread(r);

        john.setName("John");
        mary.setName("Mary");

        john.start();
        mary.start();
    }


    @Override
    public void run() {
        for(int i=1; i<=5; i++) {
            makeWithdrawal(10);
            if(acct.getBalance() < 0) {
                System.out.println("Account is overdrawn!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }


    private void makeWithdrawal(int amtToWithdraw) { // use synchronized keyword to fix race condition
        if (acct.getBalance() >= amtToWithdraw) {
            System.out.println(Thread.currentThread().getName() + ". Balance BEFORE: " + acct.getBalance());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            acct.withdraw(amtToWithdraw);
            System.out.println(Thread.currentThread().getName() + ". Balance AFTER: "+ acct.getBalance());
        } else {
            System.out.println(Thread.currentThread().getName() + " is unable to withdraw as balance is: " + acct.getBalance());
        }
    }

}
