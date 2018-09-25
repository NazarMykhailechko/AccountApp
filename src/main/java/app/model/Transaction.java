package app.model;

public class Transaction {

    private static Account account = new Account(100000.00);
    private TransactionType type;
    private double operationSum;

    public Transaction() {
    }

    public Transaction(TransactionType type, double operationSum) {
        this.type = type;
        this.operationSum = operationSum;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(double operationSum) {
        this.operationSum = operationSum;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", operationSum=" + operationSum +
                '}';
    }
}
