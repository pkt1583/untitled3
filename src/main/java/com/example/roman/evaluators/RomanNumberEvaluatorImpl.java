package com.example.roman.evaluators;

import com.example.model.RomanNumber;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomanNumberEvaluatorImpl implements RomanNumberEvaluator {
    @Override
    public int evaluate(RomanNumber... numbers) {
        int calculatedNumber = 0;
        RomanNumber previousNumber = null;
        for (RomanNumber number : numbers) {
            if (previousNumber != null && previousNumber.isLessThan(number) && previousNumber.canBeSubstractedFrom(number)) {
                int difference = number.substract(previousNumber);
                calculatedNumber = calculatedNumber - previousNumber.getValue(); //this is problem
                calculatedNumber = calculatedNumber + difference;
            } else {
                calculatedNumber = calculatedNumber + number.getValue();
            }
            previousNumber = number;
        }
        return calculatedNumber;
    }
}
