package com.example.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomanNumber {
    private Set<RomanNumber> substractList = new HashSet<RomanNumber>();
    private int value;

    public RomanNumber(int value) {
        setValue(value);

    }

    public RomanNumber() {
    }

    public boolean isLessThan(RomanNumber number) {
        return value < number.getValue();
    }

    public boolean canBeSubstractedFrom(RomanNumber number) {
        return substractList.contains(number);
    }

    public void addCanBeSubstractList(RomanNumber... numbers) {
        substractList.addAll(Arrays.asList(numbers));
    }

    public int getValue() {
        return value;
    }

    public int substract(RomanNumber number) {
        if (number == null) return 0;
        return this.getValue() - number.getValue();
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomanNumber)) return false;

        RomanNumber number = (RomanNumber) o;

        if (value != number.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.example.model.RomanNumber{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public boolean isMultipleOf(Integer num) {
        return this.value % num == 0;
    }
}
