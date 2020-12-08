package com.group7.prototype.jpa;


import com.group7.prototype.model.Sales;
import org.springframework.data.repository.CrudRepository;

public interface jpaSalesRepo extends CrudRepository<Sales,Integer> {
}
