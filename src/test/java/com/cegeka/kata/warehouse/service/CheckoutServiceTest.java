package com.cegeka.kata.warehouse.service;

import com.cegeka.kata.warehouse.model.Item;
import com.cegeka.kata.warehouse.model.ItemList;
import com.cegeka.kata.warehouse.util.EuroValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutServiceTest {

    @Autowired
    public CheckoutService service;

    @Test
    public void test_totalAmount() {
        Item itemPriceOneEuro = mock(Item.class);
        when(itemPriceOneEuro.getPrice()).thenReturn(EuroValue.of("5.66"));

        Item itemPriceTwoEuro = mock(Item.class);
        when(itemPriceTwoEuro.getPrice()).thenReturn(EuroValue.of("1.22"));

        ItemList itemList = new ItemList(itemPriceOneEuro, itemPriceTwoEuro);
        assertThat(service.getTotalAmount(itemList)).isEqualTo(EuroValue.of("6.88"));
    }
}