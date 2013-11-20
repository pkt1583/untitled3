package com.example.roman.evaluators;

import com.example.creators.AbstractRomanNumberFactory;
import com.example.model.RomanNumber;
import com.example.util.NumberSplitter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pankaj
 */
public class ArabicNumberEvaluatorImpl implements ArabicNumberEvaluator {
    AbstractRomanNumberFactory factory = AbstractRomanNumberFactory.getInstance();

    @Override
    public List<RomanNumber> evaluate(int number) {
        List<Integer> splittedNumber = new ArrayList<Integer>();
        NumberSplitter.getSplitNumberAndPutToList(number, splittedNumber);
        List<Integer> seperatedNum = NumberSplitter.addRequiredZeros(splittedNumber);
        for (int value : seperatedNum) {
            List<Integer> closestNumber = getClosestNumber(value);
        }
        return null;
    }


    public List<Integer> getClosestNumber(int value) {
        System.out.println(factory.numberCache);
        return null;
    }


}
