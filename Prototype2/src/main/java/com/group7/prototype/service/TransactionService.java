package com.group7.prototype.service;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Transactions;

import java.text.ParseException;
import java.util.List;

public interface TransactionService {

    List<Transactions> findAllTransactions();

    Transactions addTransaction(Transactions transactions);

    Transactions createTransaction(List<Cart> order);

    Transactions findTransactionByIndex(int index);

    String total();

    List<Transactions> findTransactionsday() throws ParseException;

    List<Transactions> findTransactionsweek() throws ParseException;

    List<Transactions> findTransactionsmonth() throws ParseException;
}
