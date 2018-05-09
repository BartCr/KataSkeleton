package com.cegeka.kata.warehouse.model;

import com.cegeka.kata.warehouse.model.item.Item;
import com.cegeka.kata.warehouse.util.EuroValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemListTest {

    @Test
    public void test_totalAmount() {
        Item itemPriceOneEuro = mock(Item.class);
        when(itemPriceOneEuro.getPrice()).thenReturn(EuroValue.of("1.00"));

        Item itemPriceTwoEuro = mock(Item.class);
        when(itemPriceTwoEuro.getPrice()).thenReturn(EuroValue.of("2.00"));

        ItemList itemList = new ItemList(itemPriceOneEuro, itemPriceTwoEuro);
        assertThat(itemList.getTotalAmount()).isEqualTo(EuroValue.of("3.00"));
    }

    @Test
    public void test_totalAmount_sameItemMultipleTimesInList() {
        Item itemPriceOneEuro = mock(Item.class);
        when(itemPriceOneEuro.getPrice()).thenReturn(EuroValue.of("1.00"));

        ItemList itemList = new ItemList(itemPriceOneEuro, itemPriceOneEuro, itemPriceOneEuro);
        assertThat(itemList.getTotalAmount()).isEqualTo(EuroValue.of("3.00"));
    }

    @Test
    public void test_totalAmount_emptyList() {
        ItemList itemList = new ItemList();
        assertThat(itemList.getTotalAmount()).isEqualTo(EuroValue.ZERO);
    }
}