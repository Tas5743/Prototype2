package com.group7.prototype.repository.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Transactions;
import com.group7.prototype.service.CartService;
import com.group7.prototype.repository.TransactionsRepository;
import org.springframework.stereotype.Repository;
import sun.util.calendar.BaseCalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class TransactionsRepositoryimpl implements TransactionsRepository {

    private List<Transactions> transactionsList = new ArrayList<>();

    @Override
    public List<Transactions> findAllTransactions() {
        return transactionsList;
    }

    @Override
    public Transactions addTransaction(Transactions transactions) {
        transactionsList.add(transactions);
        return transactions;
    }

    @Override
    public Transactions createTransaction(List<Cart> order) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String fDate = format.format(date);
        int index = findAllTransactions().size();
        Double total = 0.0;
        for (Cart cart : order) total = cart.getPrice() * cart.getQuantity();
        return new Transactions(index, order, fDate, total);
    }
}
