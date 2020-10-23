package com.darksideoftherainbow.model;

import javax.persistence.*;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_user_id_seq")
    @SequenceGenerator(name = "application_user_id_seq", sequenceName = "application_user_id_seq", allocationSize = 100)
    protected Long userId;
    protected String username;
    protected String password;
    protected Boolean isAdmin;

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
