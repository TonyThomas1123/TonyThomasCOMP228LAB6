public class Account {
    private double balance; // Stores the account balance//

    // Initialize with an initial balance//
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit money (thread-safe)//
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Add to balance
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount);
        }
    }

    // Withdraw money (thread-safe)//
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount; // Subtract from balance//
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: $" + amount + " (Insufficient funds)");
        }
    }

    // Get the current balance//
    public double getBalance() {
        return balance;
    }
}
//Program Ends//