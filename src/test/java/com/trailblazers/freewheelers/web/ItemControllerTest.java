package com.trailblazers.freewheelers.web;

import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.model.ItemType;
import com.trailblazers.freewheelers.service.ItemService;
import com.trailblazers.freewheelers.service.ServiceResult;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemControllerTest {

    @Mock
    ItemService itemService;
    @Mock
    SqlSession sqlSession;

    Model model;
    ItemGrid itemGrid;
    Item item;
    ItemController itemController;

    @Before
    public void setUp(){
        initMocks(this);
        itemController = new ItemController();
        itemController.itemService = itemService;
        model = new ExtendedModelMap();
        item = new Item();
    }

    @Test
    public void shouldRenderItemListView() throws Exception {
        String returnedPath = itemController.get(model, item);
        assertThat(returnedPath, is(ItemController.ITEM_LIST_PAGE));
    }

    @Test
    public void shouldReturnItemsForDisplay() throws Exception {

        itemGrid = new ItemGrid();
        when(itemService.findAll()).thenReturn(itemGrid);

        itemController.get(model, item);

        verify(itemService).findAll();
        assertThat((ItemGrid) model.asMap().get("itemGrid"), is(itemGrid));
        assertThat((ItemType[])model.asMap().get("itemTypes"), is(ItemType.values()));

    }

    @Test
    public void shouldDisplayItemsAfterSavingGivenItem(){

        Map errors = new HashMap<String, String>();
        ServiceResult<Item> serviceResultNoErrors = new ServiceResult<Item>(errors, item);
        when(itemService.saveItem(item)).thenReturn(serviceResultNoErrors);

        String returnedPath = itemController.post(model, item);

        verify(itemService).saveItem(item);
        assertThat(returnedPath, is("redirect:" + ItemController.ITEM_PAGE));

    }

    @Test
    public void shouldDisplayErrorsIfAnyAfterSavingItem(){

        Map errors = new HashMap<String, String>();
        errors.put("name", "your name is empty");
        ServiceResult<Item> serviceResultWithErrors = new ServiceResult<Item>(errors, item);

        when(itemService.saveItem(item)).thenReturn(serviceResultWithErrors);

        String returnedPath = itemController.post(model, item);

        assertThat((HashMap<String, String>) model.asMap().get("errors"), is(errors));
        verify(itemService).findAll();
        assertThat((ItemGrid) model.asMap().get("itemGrid"), is(itemGrid));
        assertThat((ItemType[])model.asMap().get("itemTypes"), is(ItemType.values()));
        assertThat(returnedPath, is(ItemController.ITEM_LIST_PAGE));

    }
}
