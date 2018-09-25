package app.service;

import app.dao.Dao;
import app.exception.TransactionRefuseException;
import app.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceImpl implements Service{

    @Autowired
    private Dao dao;

    @Override
    public void provideTransaction(Transaction transaction) throws TransactionRefuseException {
        dao.provideTransaction(transaction);
    }

    @Override
    public List<Transaction> showTransactions() {
        return dao.showTransactions();
    }
}
