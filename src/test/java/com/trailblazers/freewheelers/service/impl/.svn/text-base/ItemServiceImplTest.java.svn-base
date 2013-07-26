package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.ItemMapper;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.service.ItemService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemServiceImplTest {

    @Mock
    ItemMapper itemMapper;

    @Mock
    SqlSession sqlSession;

    ItemService itemService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(sqlSession.getMapper(ItemMapper.class)).thenReturn(itemMapper);
        itemService = new ItemServiceImpl(sqlSession);
    }

    @Test
    public void shouldGetItemByNameFromMapper(){
        String name = "name";
        Item expectedItem = new Item();
        when((itemMapper.getByName(name))).thenReturn(expectedItem);

        Item returnedItem = itemService.getByName(name);
        verify(itemMapper).getByName(name);
        assertThat(returnedItem, is(expectedItem));
    }
}
