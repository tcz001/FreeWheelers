package com.trailblazers.freewheelers.model;

public class Account {

    private Long account_id;
    private String account_name;
    private String password;
    private boolean enabled;
    private String emailAddress;
    private String phoneNumber;

    public Account() {
        this.account_id = 0L;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public Account setAccount_name(String account_name) {
        this.account_name = account_name;
        return this;
    }

    public Account setAccount_id(Long account_id) {
        this.account_id = account_id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Account setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Account setEmail_address(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getEmail_address() {
        return emailAddress;
    }

    public Account setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
