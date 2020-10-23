package com.darksideoftherainbow.service;

import com.darksideoftherainbow.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUserName(String username);
}
