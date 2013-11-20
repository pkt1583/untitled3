package com.example.model;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuccessiveRepeatableRomanNumber extends RomanNumber {
    private int times;

    public SuccessiveRepeatableRomanNumber(int value) {
        super(value);
    }

    public SuccessiveRepeatableRomanNumber() {
        super();
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int noOfOcc) {
        this.times = noOfOcc;
    }
}
