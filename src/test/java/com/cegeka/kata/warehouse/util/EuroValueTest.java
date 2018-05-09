package com.cegeka.kata.warehouse.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class EuroValueTest {

    @Test
    public void test_construct() {
        assertThatCode(() -> EuroValue.of("1.00")).doesNotThrowAnyException();
        assertThatCode(() -> EuroValue.of("1")).doesNotThrowAnyException();

        assertThatThrownBy(() -> EuroValue.of("1.001")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> EuroValue.of("1,00")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void test_compare() {
        assertThat(EuroValue.of("1.00").compareTo(EuroValue.of("1"))).isZero();
        assertThat(EuroValue.of("1.00").compareTo(EuroValue.of("0"))).isPositive();
        assertThat(EuroValue.of("1.00").compareTo(EuroValue.of("2"))).isNegative();
    }

    @Test
    public void test_equals() {
        assertThat(EuroValue.of("1.00")).isEqualTo(EuroValue.of("1.00"));
        assertThat(EuroValue.of("1.00")).isEqualTo(EuroValue.of("1"));

        assertThat(EuroValue.of("1.00")).isNotEqualTo(EuroValue.of("0.99"));
        assertThat(EuroValue.of("1.00")).isNotEqualTo(EuroValue.of("1.01"));
    }

    @Test
    public void test_add() {
        EuroValue one = EuroValue.of("1.00");
        EuroValue two = EuroValue.of("2.00");

        assertThat(one.add(one)).isEqualTo(two);
        assertThat(one.add(two)).isEqualTo(EuroValue.of("3.00"));
    }

    @Test
    public void test_multiply() {
        EuroValue one = EuroValue.of("1.00");
        EuroValue two = EuroValue.of("2.00");

        assertThat(one.multiply(2)).isEqualTo(two);
        assertThat(one.multiply(1)).isEqualTo(one);

        assertThat(one.multiply(0.333)).isEqualTo(EuroValue.of("0.34"));
    }
}