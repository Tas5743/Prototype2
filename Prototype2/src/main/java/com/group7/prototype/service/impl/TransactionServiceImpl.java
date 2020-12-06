package com.group7.prototype.service.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Transactions;
import com.group7.prototype.repository.TransactionsRepository;
import com.group7.prototype.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.MoreCollectors;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public List<Transactions> findAllTransactions() {
        return transactionsRepository.findAllTransactions();
    }

    @Override
    public Transactions addTransaction(Transactions transactions) {
        return transactionsRepository.addTransaction(transactions);
    }

    @Override
    public Transactions createTransaction(List<Cart> order) {
        return transactionsRepository.createTransaction(order);
    }

    @Override
    public Transactions findTransactionByIndex(int index) {
        return transactionsRepository.findTransactionByIndex(index);
    }

    @Override
    public String total() {
        double total = 50000.0;
        List<Transactions> transactionsList = transactionsRepository.findAllTransactions();
        for (Transactions transactions : transactionsList) total += transactions.getTotal();
        return new DecimalFormat("$#.###").format(total);
    }


    @Override
    public List<Transactions> findTransactionsday() throws ParseException {
        List<Transactions> transactionsList = transactionsRepository.findAllTransactions();
        List<Transactions> valid = new ArrayList<>();
        SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar currentDateDay = Calendar.getInstance();
        currentDateDay.add(Calendar.DAY_OF_WEEK,-1);
        Date dateCurrent = Calendar.getInstance().getTime();
        for(Transactions transactions: transactionsList){
            Date sale = convert.parse(transactions.getDate());
            if (sale.before(dateCurrent) && sale.after(currentDateDay.getTime())){
                valid.add(transactions);
            }

        }
        return valid;
    }

    @Override
    public List<Transactions> findTransactionsweek() throws ParseException {
        List<Transactions> transactionsList = transactionsRepository.findAllTransactions();
        List<Transactions> valid = new ArrayList<>();
        SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar currentDateWeek = Calendar.getInstance();
        currentDateWeek.add(Calendar.WEEK_OF_MONTH,-1);
        Date dateCurrent = Calendar.getInstance().getTime();
        for(Transactions transactions: transactionsList){
            Date sale = convert.parse(transactions.getDate());
            if (sale.before(dateCurrent) && sale.after(currentDateWeek.getTime())){
                valid.add(transactions);
            }

        }
        return valid;
    }

    @Override
    public List<Transactions> findTransactionsmonth() throws ParseException {
        List<Transactions> transactionsList = transactionsRepository.findAllTransactions();
        List<Transactions> valid = new ArrayList<>();
        SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar currentDateMonth = Calendar.getInstance();
        currentDateMonth.add(Calendar.MONTH,-1);
        Date dateCurrent = Calendar.getInstance().getTime();
        for(Transactions transactions: transactionsList){
            Date sale = convert.parse(transactions.getDate());
            if (sale.before(dateCurrent) && sale.after(currentDateMonth.getTime())){
                valid.add(transactions);
            }
        }
        return valid;
    }


}
