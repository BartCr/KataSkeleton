package com.cegeka.kata.warehouse.model.item;

import com.cegeka.kata.warehouse.util.EuroValue;

public class PricePerKgItem implements Item {

    private final String name;
    private final EuroValue price;
    private final double amount;

    PricePerKgItem(String name, EuroValue price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public EuroValue getPrice() {
        return price.multiply(amount);
    }
}
