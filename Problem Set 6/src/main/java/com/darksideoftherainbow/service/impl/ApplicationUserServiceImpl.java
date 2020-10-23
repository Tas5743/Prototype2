package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import com.darksideoftherainbow.service.ApplicationUserService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    // auto-wired
    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
