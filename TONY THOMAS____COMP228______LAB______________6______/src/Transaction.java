public class Transaction implements Runnable {
    private final Account account; // Account to use//
    private final double amount;   // Transaction amount//
    private final boolean isDeposit; // true = deposit, false = withdraw//

    // Initialize transaction details//
    public Transaction(Account account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    // Run transaction//
    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount); // Deposit//
        } else {
            account.withdraw(amount); // Withdraw//
        }
    }
}
//program Ends//