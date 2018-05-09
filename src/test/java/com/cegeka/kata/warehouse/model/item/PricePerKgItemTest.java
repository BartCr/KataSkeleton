package com.cegeka.kata.warehouse.model.item;

import com.cegeka.kata.warehouse.util.EuroValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PricePerKgItemTest {

    @Test
    public void test_price() {
        assertThat(new PricePerKgItem("apple", EuroValue.of("2.99"), 2).getPrice()).isEqualTo(EuroValue.of("5.98"));
        assertThat(new PricePerKgItem("apple", EuroValue.of("2.99"), 0.43).getPrice()).isEqualTo(EuroValue.of("1.29"));
    }

}