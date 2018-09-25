package app.dao;

import app.exception.TransactionRefuseException;
import app.model.Account;
import app.model.Transaction;

import java.util.List;

public interface Dao {

    void provideTransaction(Transaction transaction) throws TransactionRefuseException;
    List<Transaction> showTransactions();

}
