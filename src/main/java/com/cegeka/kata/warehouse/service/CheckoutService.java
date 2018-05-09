package com.cegeka.kata.warehouse.service;

import com.cegeka.kata.warehouse.model.ItemList;
import com.cegeka.kata.warehouse.util.EuroValue;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    public EuroValue getTotalAmount(ItemList itemList) {
        return itemList.getTotalAmount();
    }
}
