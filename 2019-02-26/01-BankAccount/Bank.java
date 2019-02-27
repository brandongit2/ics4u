public class Bank {
    public static void main(String[] args) {
        final BankAccount acct = new BankAccount();
        
        acct.setName("Brandon");
        
        try {
            acct.deposit(1);
            acct.deposit(1584099.454252);
            acct.withdraw(249378.523);
            acct.deposit(1);
            acct.withdraw(2490907908.523);
        } catch (TransactionError err) {
            if (err.type() == TransactionErrorTypes.INVALID_DEPOSIT) {
                System.out.println("Invalid deposit amount.");
            } else if (err.type() == TransactionErrorTypes.INVALID_WITHDRAW) {
                System.out.println("Invalid deposit amount.");
            } else {
                System.out.println("Unknown error occured.");
            }
            
            System.exit(1);
        }
        
        System.out.println(acct.toString());
    }
}
