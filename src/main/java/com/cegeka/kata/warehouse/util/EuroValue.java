package com.cegeka.kata.warehouse.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EuroValue implements Comparable<EuroValue> {

    public static final EuroValue ZERO = EuroValue.of("0.00");

    private final BigDecimal internal;

    public static EuroValue of(double value) {
        return new EuroValue(new BigDecimal(value));
    }

    public static EuroValue of(String value) {
        return new EuroValue(new BigDecimal(value));
    }

    private EuroValue(BigDecimal internal) {
        Objects.requireNonNull(internal);
        if (internal.signum() == -1) {
            throw new IllegalArgumentException("EuroValue should never be negative.");
        }
        if (internal.scale() > 2) {
            throw new IllegalArgumentException("EuroValue should not have more than 2 decimal digits.");
        }
        if (internal.scale() < 2) {
            this.internal = internal.setScale(2, RoundingMode.UNNECESSARY);
        } else {
            this.internal = internal;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EuroValue euroValue = (EuroValue) o;
        return Objects.equals(internal, euroValue.internal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internal);
    }

    @Override
    public int compareTo(EuroValue o) {
        return internal.compareTo(o.internal);
    }

    @Override
    public String toString() {
        return internal.toString();
    }

    public EuroValue add(EuroValue other) {
        return new EuroValue(this.internal.add(other.internal));
    }

}
