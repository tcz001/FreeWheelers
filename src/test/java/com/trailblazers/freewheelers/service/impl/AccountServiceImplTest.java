package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.AccountMapper;
import com.trailblazers.freewheelers.mappers.AccountRoleMapper;
import com.trailblazers.freewheelers.mappers.AddressMapper;
import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.AccountRole;
import com.trailblazers.freewheelers.model.Address;
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
    @Mock
    AddressMapper addressMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(sqlSession.getMapper(AccountMapper.class)).thenReturn(accountMapper);
        when(sqlSession.getMapper(AccountRoleMapper.class)).thenReturn(accountRoleMapper);
        when(sqlSession.getMapper(AddressMapper.class)).thenReturn(addressMapper);
        accountService = new AccountServiceImpl(sqlSession);
    }

    @Test
    public void shouldNotCreateAccountWhenThereAreValidationErrors(){
        Account account = getAccountWithErrors();
        Address address = getAddressWithoutErrors();

        ServiceResult<Account> serviceResult = accountService.createAccount(account,address);

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
        Address address = getAddressWithoutErrors();

        ServiceResult<Account> serviceResult = accountService.createAccount(account,address);

        verify(accountMapper, times(1)).insert(account);
        verify(accountRoleMapper, times(1)).insert(any(AccountRole.class));
        verify(sqlSession, times(1)).commit();
        assertFalse(serviceResult.hasErrors());
    }

    private Address getAddressWithoutErrors() {
        Address address = new Address();
        address.setAccount_id(0L);
        address.setStreet1("1");
        address.setStreet2("2");
        address.setCity("London");
        address.setState("Great London");
        address.setCountry("UK");
        address.setZipCode("NW1");
        return address;
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
