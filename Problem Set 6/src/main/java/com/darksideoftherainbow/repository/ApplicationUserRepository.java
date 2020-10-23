package com.darksideoftherainbow.repository;

import com.darksideoftherainbow.model.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser addUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);
}
