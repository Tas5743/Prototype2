package com.group7.prototype.jpa;

import com.group7.prototype.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface jpaItemRepo extends CrudRepository<Item, Integer> {
}
