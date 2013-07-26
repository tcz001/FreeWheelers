package integration.com.trailblazers.freewheelers.persistence;

import com.trailblazers.freewheelers.mappers.AccountRoleMapper;
import com.trailblazers.freewheelers.model.AccountRole;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountRoleMapperTest extends MapperTestBase {

    private AccountRoleMapper accountRoleMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        accountRoleMapper = getSqlSession().getMapper(AccountRoleMapper.class);
    }

    @Test
    public void shouldInsertAnAccountRole() throws Exception {
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount_name("Some Name");
        accountRole.setRole("Some Role");

        accountRoleMapper.insert(accountRole);

        assertThat(accountRole.getRole_id(), is(not(nullValue())));
    }

}
