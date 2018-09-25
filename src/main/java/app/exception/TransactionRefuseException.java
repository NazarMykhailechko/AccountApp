package app.exception;

public class TransactionRefuseException extends Exception {

    public TransactionRefuseException(String message) {
        System.out.println(message);
    }
}
