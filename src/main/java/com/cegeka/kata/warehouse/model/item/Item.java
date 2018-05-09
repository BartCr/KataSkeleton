package com.cegeka.kata.warehouse.model.item;

import com.cegeka.kata.warehouse.util.EuroValue;

public interface Item {
    EuroValue getPrice();

    static Item fixedPrice(String name, EuroValue value) {
        return new FixedPriceItem(name, value);
    }

    static Item pricePerKg(String name, EuroValue value, double amount) {
        return new PricePerKgItem(name, value, amount);
    }


}
