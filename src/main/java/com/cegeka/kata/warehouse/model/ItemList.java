package com.cegeka.kata.warehouse.model;

import com.cegeka.kata.warehouse.model.item.Item;
import com.cegeka.kata.warehouse.util.EuroValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ItemList {

    private final List<Item> items;

    public ItemList() {
        items = new ArrayList<>();
    }

    public ItemList(Item... values) {
        this();
        items.addAll(Arrays.asList(values));
    }

    public ItemList with(Item value) {
        items.add(value);
        return this;
    }

    public EuroValue getTotalAmount() {
        return items.stream().map(Item::getPrice).reduce(EuroValue.ZERO, EuroValue::add);
    }
}
