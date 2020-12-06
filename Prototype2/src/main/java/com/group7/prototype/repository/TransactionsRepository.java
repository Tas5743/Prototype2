package com.group7.prototype.repository;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Transactions;

import java.util.Date;
import java.util.List;

public interface TransactionsRepository {

    List<Transactions> findAllTransactions();

    Transactions addTransaction(Transactions transactions);

    Transactions createTransaction(List<Cart> order);

    Transactions findTransactionByIndex(int index);


}
