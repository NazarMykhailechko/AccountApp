package app.service;

import app.exception.TransactionRefuseException;
import app.model.Transaction;

import java.util.List;

public interface Service {

    void provideTransaction(Transaction transaction) throws TransactionRefuseException;
    List<Transaction> showTransactions();

}
