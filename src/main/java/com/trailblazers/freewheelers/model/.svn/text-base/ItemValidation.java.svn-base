package com.trailblazers.freewheelers.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class ItemValidation {

    public Map<String, String> validate(Item item) {
        Map<String, String> errors = new HashMap<String, String>();

        if (item.getName().isEmpty()) {
            errors.put("name", "Please enter Item Name");
        }

        if (item.getPrice() == null) {
            errors.put("price", "Please enter Item Price");
        }

        if (item.getQuantity() == null) {
            errors.put("quantity", "Please enter Item Quantity");
        }

        if (item.getType() == null) {
            errors.put("type", "Please enter Item Type");
        }

        if (item.getDescription().isEmpty()) {
            errors.put("description", "Please enter Item Description");
        }

        if (item.getPrice() == null) {
            errors.put("price", "Please enter Item Price");
        }

        if((item.getPrice() != null) && item.getPrice().compareTo(BigDecimal.valueOf(100000.00)) != -1) {
            errors.put("price", "must be less than or equal to 99999");
        }

        return errors;
    }
}
