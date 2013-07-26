package com.trailblazers.freewheelers.web;

import com.trailblazers.freewheelers.model.Item;

import java.util.*;

public class ItemGrid {
	
	private Map<Long, Item> itemMap;

    public ItemGrid() {
        itemMap = new HashMap<Long, Item>();
    }
	                                             
	public ItemGrid(List<Item> items) {
        this();
        for (Item item : items) {
            itemMap.put(item.getItemId(), item);

        }
    }
	
	public List<Item> getItems() {
		return new ArrayList<Item>(itemMap.values());
	}

	public Map<Long, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<Long, Item> items) {
		this.itemMap = items;
	}
	
}
