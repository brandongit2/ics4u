public class TransactionError extends Exception {
    private TransactionErrorTypes type;
    
    public TransactionError(TransactionErrorTypes type) {
        super();
        this.type = type;
    }
    
    public TransactionErrorTypes type() {
        return type;
    }
}
