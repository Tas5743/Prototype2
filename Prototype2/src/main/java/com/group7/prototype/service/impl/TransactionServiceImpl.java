package com.group7.prototype.service.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Transactions;
import com.group7.prototype.repository.TransactionsRepository;
import com.group7.prototype.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
