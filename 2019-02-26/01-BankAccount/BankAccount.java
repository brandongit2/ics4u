import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private String name;
    private ArrayList<Double> recentTransactions = new ArrayList<>();
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) throws TransactionError {
        if (amount > 0) {
            balance += amount;
            recentTransactions.add(0, amount);
        } else {
            throw new TransactionError(TransactionErrorTypes.INVALID_DEPOSIT);
        }
    }
    
    public void withdraw(double amount) throws TransactionError {
        if (amount > 0) {
            balance -= amount;
            recentTransactions.add(0, -amount);
        } else {
            throw new TransactionError(TransactionErrorTypes.INVALID_WITHDRAW);
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        String transactions = "";
        for (int i = 0; i < Math.min(5, recentTransactions.size()); i++) {
            if (recentTransactions.get(i) != 0) {
                if (recentTransactions.get(i) < 0) {
                    transactions += "Withdrew  ";
                } else {
                    transactions += "Deposited ";
                }
                
                transactions += String.format("$%.2f\n", Math.abs(recentTransactions.get(i)));
            } else {
                transactions = "No recent transactions!";
            }
        }
        
        return String.format("Hello, %s.\nYour balance is $%.2f.\n\nRECENT TRANSACTIONS (newest to oldest)\n--------------------------------------\n%s", name, balance, transactions);
    }
}
