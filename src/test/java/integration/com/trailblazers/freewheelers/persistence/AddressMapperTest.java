package integration.com.trailblazers.freewheelers.persistence;

import com.trailblazers.freewheelers.mappers.AddressMapper;
import com.trailblazers.freewheelers.model.Address;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddressMapperTest extends MapperTestBase {
    private AddressMapper addressMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        addressMapper = getSqlSession().getMapper(AddressMapper.class);
    }

    @Test
    public void shouldInsertAnAddress() throws Exception {
        Address address = new Address();

        addressMapper.insert(address);

        assertThat(address.getAddress_id(), is(not(nullValue())));
    }
}
