package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.AccountMapper;
import com.trailblazers.freewheelers.mappers.AccountRoleMapper;
import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.AccountRole;
import com.trailblazers.freewheelers.mappers.MyBatisUtil;
import com.trailblazers.freewheelers.model.AccountValidation;
import com.trailblazers.freewheelers.service.AccountService;
import com.trailblazers.freewheelers.service.ServiceResult;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    public static final String USER = "ROLE_USER";
    private static final String ADMIN = "ROLE_ADMIN";

    private final AccountRoleMapper accountRoleMapper;
    private SqlSession sqlSession;
    private AccountMapper accountMapper;

    public AccountServiceImpl() {
        this(MyBatisUtil.getSqlSessionFactory().openSession());
    }

    public AccountServiceImpl(SqlSession sqlSession) {
        this.sqlSession= sqlSession;
        this.accountMapper = sqlSession.getMapper(AccountMapper.class);
        this.accountRoleMapper = sqlSession.getMapper(AccountRoleMapper.class);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public Account getAccountIdByName(String userName) {
        return accountMapper.getByName(userName);
    }

    @Override
    public Account get(Long account_id) {
        return accountMapper.getById(account_id);
    }

    @Override
    public void delete(Account account) {
        accountMapper.delete(account);
        sqlSession.commit();
    }

    @Override
    public void createAdmin(Account account) {
        create(account, ADMIN);
    }

    @Override
    public ServiceResult<Account> createAccount(Account account) {
        HashMap errors = AccountValidation.verifyInputs(account);

        if(errors.isEmpty()) {
            create(account, USER);
        }

        return new ServiceResult(errors, account);
    }

    private void create(Account account, String role) {
        accountMapper.insert(account);
        accountRoleMapper.insert(roleFor(account, role));
        sqlSession.commit();
    }

    private AccountRole roleFor(Account account, String role) {
        return new AccountRole()
                .setAccount_name(account.getAccount_name())
                .setRole(role);
    }
}
