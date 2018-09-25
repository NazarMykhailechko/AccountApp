package app.controller;

import app.exception.TransactionRefuseException;
import app.model.Transaction;
import app.model.TransactionType;
import app.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTransaction(@RequestParam("type") String type, @RequestParam("sum") double sum) throws TransactionRefuseException {

        Transaction transaction = new Transaction();
        if (type.equals("credit")) {
            transaction.setType(TransactionType.CREDIT);
            transaction.setOperationSum(sum);
        }
        if (type.equals("debit")) {
            transaction.setType(TransactionType.DEBIT);
            transaction.setOperationSum(sum);
        }

        service.provideTransaction(transaction);
        return "index";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Transaction> showTransactions() {
        return service.showTransactions();
    }
}