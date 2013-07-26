package com.trailblazers.freewheelers.model;

public enum ItemType {
    FRAME("FRAME"),
    ACCESSORIES("ACCESSORIES");

    private String value;

    private ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}