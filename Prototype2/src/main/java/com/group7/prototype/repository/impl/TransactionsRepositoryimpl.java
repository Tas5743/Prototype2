package com.group7.prototype.repository.impl;

import com.group7.prototype.jpa.jpaSalesRepo;
import com.group7.prototype.jpa.jpaTransactionRepo;
import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Sales;
import com.group7.prototype.model.Transactions;
import com.group7.prototype.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class TransactionsRepositoryimpl implements TransactionsRepository {

    @Autowired
    private jpaTransactionRepo jpaTransactionRepo;

    @Autowired
    private jpaSalesRepo salesRepo;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Transactions> findAllTransactions() {
        return (List<Transactions>) jpaTransactionRepo.findAll();
    }

    @Override
    public Transactions addTransaction(Transactions transactions) {
        return jpaTransactionRepo.save(transactions);
    }

    @Override
    public Transactions createTransaction(List<Cart> order) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        List<Sales> transactions = new ArrayList<>();
        Date date = new Date();
        String fDate = format.format(date);
        Double total = 0.0;
        for (Cart cart : order) {total += cart
                .getPrice() * cart.getQuantity();
             Sales purchase = new Sales(cart.getName(),cart.getPrice(),cart.getQuantity());
            transactions.add(purchase);
            salesRepo.save(purchase);
        }
          Transactions sale = new Transactions(fDate, total,transactions);
        jpaTransactionRepo.save(sale);
        for (Sales sell : transactions){
            sell.setTransactions(sale);
        }
        return  sale;
    }

    @Override
    public Transactions findTransactionByIndex(int index) {
        Optional<Transactions> optionalTransactions = jpaTransactionRepo.findById(index);
        if (optionalTransactions.isPresent())return optionalTransactions.get();
        return null;
    }




}
