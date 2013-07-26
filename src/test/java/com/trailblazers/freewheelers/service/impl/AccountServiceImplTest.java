package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.AccountMapper;
import com.trailblazers.freewheelers.mappers.AccountRoleMapper;
import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.AccountRole;
import com.trailblazers.freewheelers.service.AccountService;
import com.trailblazers.freewheelers.service.ServiceResult;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountServiceImplTest {

    AccountService accountService;

    @Mock
    SqlSession sqlSession;
    @Mock
    AccountMapper accountMapper;
    @Mock
    AccountRoleMapper accountRoleMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(sqlSession.getMapper(AccountMapper.class)).thenReturn(accountMapper);
        when(sqlSession.getMapper(AccountRoleMapper.class)).thenReturn(accountRoleMapper);

        accountService = new AccountServiceImpl(sqlSession);
    }

    @Test
    public void shouldNotCreateAccountWhenThereAreValidationErrors(){
        Account account = getAccountWithErrors();

        ServiceResult<Account> serviceResult = accountService.createAccount(account);

        verify(accountMapper, never()).insert(account);
        verify(accountRoleMapper, never()).insert(any(AccountRole.class));
        verify(sqlSession, never()).commit();
        assertTrue(serviceResult.hasErrors());
    }

    private Account getAccountWithErrors() {
        Account account =  new Account();
        account.setAccount_name("");
        account.setEmail_address("");
        account.setPassword("");
        account.setPhoneNumber("");
        return account;
    }

    @Test
    public void shouldCreateAccountWhenThereAreNoValidationErrors(){
        Account account = getAccountWithoutErrors();

        ServiceResult<Account> serviceResult = accountService.createAccount(account);

        verify(accountMapper, times(1)).insert(account);
        verify(accountRoleMapper, times(1)).insert(any(AccountRole.class));
        verify(sqlSession, times(1)).commit();
        assertFalse(serviceResult.hasErrors());
    }

    private Account getAccountWithoutErrors() {
        Account account = new Account();
        account.setEmail_address("example@example.com");
        account.setPassword("example");
        account.setAccount_name("Example Person");
        account.setPhoneNumber("1234567890");
        return account;
    }
}
