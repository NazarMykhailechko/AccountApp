package app.dao;

import app.exception.TransactionRefuseException;
import app.model.Transaction;
import app.model.TransactionType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoImpl implements Dao{

    private List<Transaction> transactionList;

    public DaoImpl() {
        transactionList = new ArrayList<>();
    }

    public void provideTransaction(Transaction transaction) throws TransactionRefuseException {

        double total = transaction.getAccount().getMoney();

        if(transaction.getType() == TransactionType.CREDIT){
              if(total>=transaction.getOperationSum()){
                  transaction.getAccount().setMoney(total-transaction.getOperationSum());
                  transactionList.add(transaction);
              }
              else{
                  throw new TransactionRefuseException("Refused transaction!!!");
              }
        }else{
            transaction.getAccount().setMoney(total+transaction.getOperationSum());
            transactionList.add(transaction);
        }
    }

    public List<Transaction> showTransactions() {
        return transactionList;
    }

}
