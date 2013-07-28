package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.AccountMapper;
import com.trailblazers.freewheelers.mappers.AccountRoleMapper;
import com.trailblazers.freewheelers.mappers.AddressMapper;
import com.trailblazers.freewheelers.mappers.MyBatisUtil;
import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.AccountRole;
import com.trailblazers.freewheelers.model.AccountValidation;
import com.trailblazers.freewheelers.model.Address;
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
    private AddressMapper addressMapper;

    public AccountServiceImpl() {
        this(MyBatisUtil.getSqlSessionFactory().openSession());
    }

    public AccountServiceImpl(SqlSession sqlSession) {
        this.sqlSession= sqlSession;
        this.accountMapper = sqlSession.getMapper(AccountMapper.class);
        this.addressMapper = sqlSession.getMapper(AddressMapper.class);
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
    public Address getAddressIdByAccountId(Long id) {
        return addressMapper.getByAccountId(id);
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
    public ServiceResult<Account> createAccount(Account account, Address address) {
        HashMap errors = AccountValidation.verifyInputs(account);

        if(errors.isEmpty()) {
            create(account, USER, addressFor(account,address));
        }

        return new ServiceResult(errors, account);
    }

    private void create(Account account, String role) {
        accountMapper.insert(account);
        accountRoleMapper.insert(roleFor(account, role));
        sqlSession.commit();
    }

    private void create(Account account, String role,Address address) {
        accountMapper.insert(account);
        accountRoleMapper.insert(roleFor(account, role));
        addressMapper.insert(addressFor(account,address));
        sqlSession.commit();
    }

    private AccountRole roleFor(Account account, String role) {
        return new AccountRole()
                .setAccount_name(account.getAccount_name())
                .setRole(role);
    }

    private Address addressFor(Account account, Address address) {
        return new Address()
                .setAccount_id(account.getAccount_id())
                .setStreet1(address.getStreet1())
                .setStreet2(address.getStreet2())
                .setCity(address.getCity())
                .setState(address.getState())
                .setCountry(address.getCountry())
                .setZipCode(address.getZipCode());
    }
}
