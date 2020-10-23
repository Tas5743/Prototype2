package com.darksideoftherainbow.service;

import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.model.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserDetailsService(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserService.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return new SecurityUser(user);
    }
}
