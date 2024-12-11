import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        // Initialize account with an initial balance of $1000//
        Account account = new Account(1000);

        // Create a list of transactions//
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 200, true));  // Deposit $200
        transactions.add(new Transaction(account, 150, false)); // Withdraw $150
        transactions.add(new Transaction(account, 300, true));  // Deposit $300
        transactions.add(new Transaction(account, 500, false)); // Withdraw $500
        transactions.add(new Transaction(account, 100, false)); // Withdraw $100

        // Create an ExecutorService with a fixed thread pool//
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Execute each transaction//
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shutdown the executor//
        executor.shutdown();

        // Wait for all tasks to complete//
        while (!executor.isTerminated()) {
            // Busy waiting//
        }

        // Display final account balance//
        System.out.println("Final account balance: $" + account.getBalance());
    }
}
//Program Ends//