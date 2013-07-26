package com.trailblazers.freewheelers.model;

import java.math.BigDecimal;

public class Item {

    private Long itemId;
    private String name;
    private BigDecimal price;
    private String description;
    private ItemType type;
    private Long quantity;

    public Long getItemId() {
        return itemId;
    }
    public Item setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }
    public String getName() {
        return name;
    }
    public Item setName(String name) {
        this.name = name;
        return this;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public Item setDescription(String description) {
        this.description = description;
        return this;
    }
    public ItemType getType() {
        return type;
    }
    public Item setType(ItemType type) {
        this.type = type;
        return this;
    }
    public Long getQuantity() {
        return quantity;
    }
    public Item setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

}
