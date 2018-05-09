package com.cegeka.kata.warehouse.model.item;

import com.cegeka.kata.warehouse.util.EuroValue;

public class FixedPriceItem implements Item {

    private final String name;
    private final EuroValue price;

    FixedPriceItem(String name, EuroValue price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public EuroValue getPrice() {
        return price;
    }
}
