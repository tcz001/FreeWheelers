package com.trailblazers.freewheelers.service;

import com.trailblazers.freewheelers.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account getAccountIdByName(String userName);

    Account get(Long account_id);

    void delete(Account account);

    void createAdmin(Account account);

    ServiceResult<Account> createAccount(Account account);
}
