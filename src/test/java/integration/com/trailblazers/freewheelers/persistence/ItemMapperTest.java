package integration.com.trailblazers.freewheelers.persistence;

import com.trailblazers.freewheelers.mappers.ItemMapper;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.model.ItemType;
import org.junit.Before;
import org.junit.Test;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemMapperTest extends MapperTestBase {

    public static final long AVAILABLE = 1L;
    public static final long UNAVAILABLE = 0L;
    private ItemMapper itemMapper;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        itemMapper = getSqlSession().getMapper(ItemMapper.class);
    }

    @Test
    public void shouldInsertANewItem() throws Exception {
        Item item = someItem().setItemId(null);

        itemMapper.insert(item);

        assertThat(item.getItemId(), is(not(nullValue())));
    }

    @Test
    public void shouldFetchAnItemById() throws Exception {
        Item item = someItem().setName("Awesome Item");

        itemMapper.insert(item);
        Item fetched = itemMapper.get(item.getItemId());

        assertThat(fetched.getName(), is("Awesome Item"));
    }

    @Test
    public void shouldFetchAnItemByName() throws Exception {
        Item item = someItem().setName("Some Item");

        itemMapper.insert(item);
        Item fetched = itemMapper.getByName("Some Item");

        assertThat(fetched.getName(), is("Some Item"));
    }

    @Test
    public void shouldDeleteItem() throws Exception {
        Item item = someItem();
        itemMapper.insert(item);

        itemMapper.delete(item);
        Item fetched = itemMapper.get(item.getItemId());

        assertThat(fetched, is(nullValue()));
    }

    @Test
    public void shouldUpdateAnItem() throws Exception {
        Item item = someItem().setPrice(valueOf(100.00));
        itemMapper.insert(item);

        item.setPrice(valueOf(99.99));
        itemMapper.update(item);
        Item fetched = itemMapper.get(item.getItemId());

        assertThat(fetched.getPrice(), is(valueOf(99.99)));
    }

    @Test
    public void shouldFindAllItems() throws Exception {
        int before = itemMapper.findAll().size();

        itemMapper.insert(someItem());

        assertThat(itemMapper.findAll().size(), is(before + 1));
    }

    @Test
    public void shouldShouldFindAllAvailableItems() throws Exception {
        int before = itemMapper.findAvailable().size();

        itemMapper.insert(someItem().setQuantity(AVAILABLE));
        itemMapper.insert(someItem().setQuantity(UNAVAILABLE));
        itemMapper.insert(someItem().setQuantity(UNAVAILABLE));

        assertThat(itemMapper.findAvailable().size(), is(before + 1));
    }

    private Item someItem() {
        return new Item()
                .setName("Some Item")
                .setDescription("... with a very nice description")
                .setPrice(valueOf(9.99))
                .setQuantity(100L)
                .setType(ItemType.ACCESSORIES);
    }


}
