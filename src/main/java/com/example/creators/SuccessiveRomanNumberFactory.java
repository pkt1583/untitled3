package com.example.creators;

import com.example.model.RomanNumber;
import com.example.model.SuccessiveRepeatableRomanNumber;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuccessiveRomanNumberFactory implements NumberCreator {

    @Override
    public RomanNumber createInstance(int noOfOccurance) {
        SuccessiveRepeatableRomanNumber succnumber = new SuccessiveRepeatableRomanNumber();
        succnumber.setTimes(noOfOccurance);
        return succnumber;
    }
}
