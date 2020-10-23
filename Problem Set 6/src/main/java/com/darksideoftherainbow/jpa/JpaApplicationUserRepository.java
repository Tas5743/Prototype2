package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
