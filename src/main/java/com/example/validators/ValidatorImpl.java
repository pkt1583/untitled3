package com.example.validators;

import com.example.model.RomanNumber;
import com.example.model.SuccessiveRepeatableRomanNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidatorImpl implements Validator {
    @Override
    public Map<Object, Object> validate(RomanNumber... numbers) {
        Map<Object, Object> errMap = new HashMap<Object, Object>();
        RomanNumber previousNumber = null;
        int repeatCount = 0;
        for (RomanNumber number : numbers) {
            if (number instanceof SuccessiveRepeatableRomanNumber) {
                if (previousNumber != null) {
                    if (previousNumber.equals(number)) {
                        repeatCount++;
                    } else {
                        repeatCount = 1;
                    }
                } else {
                    repeatCount++;
                }
                previousNumber = number;
                if (repeatCount == ((SuccessiveRepeatableRomanNumber) number).getTimes()) {
                    errMap.put(number, "Repeat Number found");
                }
            }
        }
        return errMap;
    }
}

