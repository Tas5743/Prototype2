package com.group7.prototype.jpa;


import com.group7.prototype.model.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface jpaTransactionRepo extends CrudRepository<Transactions,Integer> {
}
