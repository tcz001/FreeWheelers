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
        address.setAccount_id(1L);

        addressMapper.insert(address);

        assertThat(address.getAddress_id(), is(not(nullValue())));
    }

    @Test
    public void shouldGetAddressByAccountId() throws Exception {
        Address address = someAddress();
        addressMapper.insert(address);

        Address fetchedFromDB = addressMapper.getByAccountId(address.getAccount_id());
        assertThat(fetchedFromDB.getAddress_id(), is(address.getAddress_id()));
        assertThat(fetchedFromDB.getCountry(), is("UK"));
        assertThat(fetchedFromDB.getAccount_id(), is(2L));
    }

    private Address someAddress() {
        return new Address()
                   .setAccount_id(2L)
                   .setCountry("UK");
    }
}
