package com.trailblazers.freewheelers.service.impl;

import com.trailblazers.freewheelers.mappers.ItemMapper;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.mappers.MyBatisUtil;
import com.trailblazers.freewheelers.model.ItemValidation;
import com.trailblazers.freewheelers.service.ItemService;
import com.trailblazers.freewheelers.service.ServiceResult;
import com.trailblazers.freewheelers.web.ItemGrid;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class ItemServiceImpl implements ItemService {

    private final SqlSession sqlSession;
    private final ItemMapper itemMapper;

    public ItemServiceImpl() {
        this(MyBatisUtil.getSqlSessionFactory().openSession());
    }

    protected ItemServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.itemMapper = sqlSession.getMapper(ItemMapper.class);
    }

    @Override
    public Item get(Long item_id) {
        return itemMapper.get(item_id);
    }

    @Override
    public Item getByName(String name) {
        return itemMapper.getByName(name);
    }

    @Override
    public void delete(Item item) {
        itemMapper.delete(item);
        sqlSession.commit();
    }

    @Override
    public ItemGrid findAll() {
        sqlSession.clearCache();
        return new ItemGrid(itemMapper.findAll());
    }

    @Override
    public ItemGrid getItemsWithNonZeroQuantity() {
        sqlSession.clearCache();
        return new ItemGrid(itemMapper.findAvailable());
    }

    @Override
    public void saveAll(ItemGrid itemGrid) {
        for (Item item : itemGrid.getItems()) {
            insertOrUpdate(item);
            sqlSession.commit();
        }
    }

    @Override
    public void refreshItemList(ItemGrid itemGrid) {
        ItemGrid allItems = findAll();
        allItems.getItemMap().putAll(itemGrid.getItemMap());
        itemGrid.setItemMap(allItems.getItemMap());
    }

    @Override
    public void deleteItems(ItemGrid itemGrid) {
        for (Item item : itemGrid.getItems()) {
            delete(item);
        }
    }

    @Override
    public void decreaseQuantityByOne(Item item) {
        item.setQuantity(item.getQuantity() - 1);
        itemMapper.update(item);
        sqlSession.commit();
    }

    @Override
    public ServiceResult<Item> saveItem(Item item) {
        Map<String,String> errors = new ItemValidation().validate(item);

        if (errors.isEmpty()) {
            insertOrUpdate(item);
            sqlSession.commit();
        }

        return new ServiceResult<Item>(errors, item);
    }

    private void insertOrUpdate(Item item) {
        if (item.getItemId() == null) {
            itemMapper.insert(item);
        } else {
            itemMapper.update(item);
        }
    }
}
