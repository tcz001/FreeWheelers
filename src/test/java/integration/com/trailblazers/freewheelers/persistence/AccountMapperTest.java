package integration.com.trailblazers.freewheelers.persistence;

import com.trailblazers.freewheelers.mappers.AccountMapper;
import com.trailblazers.freewheelers.model.Account;
import org.junit.Before;
import org.junit.Test;

import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountMapperTest extends MapperTestBase {

    private AccountMapper accountMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        accountMapper = getSqlSession().getMapper(AccountMapper.class);
    }

    @Test
    public void shouldInsertAndGetAccount() throws Exception {
        Account account = someAccount().setAccount_name("Johnny Cash");

        accountMapper.insert(account);
        Account fetchedFromDB = accountMapper.getById(account.getAccount_id());

        assertThat(fetchedFromDB.getAccount_name(), is("Johnny Cash"));
    }

    @Test
    public void shouldGetAccountByName() throws Exception {
        accountMapper.insert(someAccount().setAccount_name("Michael Stipe"));

        Account fetchedFromDB = accountMapper.getByName("Michael Stipe");

        assertThat(fetchedFromDB.getAccount_name(), is("Michael Stipe"));
    }

    @Test
    public void shouldUpdateAnExistingAccount() throws Exception {
        Account someAccount = someAccount().setAccount_name("Prince");
        accountMapper.insert(someAccount);

        someAccount.setAccount_name("TAFKAP");
        accountMapper.update(someAccount);

        Account fetched = accountMapper.getById(someAccount.getAccount_id());
        assertThat(fetched.getAccount_name(), is("TAFKAP"));
    }

    @Test
    public void shouldFindAllAccounts() throws Exception {
        int before = accountMapper.findAll().size();

        accountMapper.insert(someAccount());
        accountMapper.insert(someAccount());
        accountMapper.insert(someAccount());

        assertThat(accountMapper.findAll().size(), is(before + 3));
    }

    @Test
    public void shouldReturnNullIfAnAccountDoesNotExist() throws Exception {
        assertThat(accountMapper.getByName("Does Not Exist"), is(nullValue()));
    }

    @Test
    public void shouldDeleteAccount() throws Exception {
        Account account = someAccount();
        accountMapper.insert(account);

        accountMapper.delete(account);
        Account fetched = accountMapper.getById(account.getAccount_id());

        assertThat(fetched, is(nullValue()));
    }
    
    private Account someAccount() {
        return new Account()
                .setAccount_name("Some Body")
                .setEmail_address(randomUUID() + "some.body@gmail.com")
                .setPassword("V3ry S3cret")
                .setPhoneNumber("12345")
                .setEnabled(true);
    }

}

