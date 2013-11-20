package com.example.roman.evaluators;

import com.example.creators.AbstractRomanNumberFactory;
import com.example.model.RomanNumber;
import com.example.model.SuccessiveRepeatableRomanNumber;
import com.example.util.NumberSplitter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pankaj
 */
public class ArabicNumberEvaluatorImpl implements ArabicNumberEvaluator {
    AbstractRomanNumberFactory factory = AbstractRomanNumberFactory.getInstance();


    @Override
    public List<RomanNumber> evaluate(int number) {
        List<Integer> intList = new ArrayList<Integer>();
        List<RomanNumber> returnList = new ArrayList<RomanNumber>();
        NumberSplitter.getSplitNumberAndPutToList(number, intList);
        intList = NumberSplitter.addRequiredZeros(intList);
        for (int i : intList) {
            System.out.println("Processing for " + i);
            List numbers = getRomanNumbers(i);
            System.out.println("The Number is " + numbers);
            returnList.addAll(numbers);
        }
        return returnList;
    }

    private List<RomanNumber> getRomanNumbers(int number) {
        Map<RomanNumber, Integer> roNumber = new LinkedHashMap<RomanNumber, Integer>();
        List<RomanNumber> numbrList = new ArrayList<RomanNumber>();
        int tryWith = number;
        while (tryWith != 0) {
            RomanNumber targetNumber = factory.getNumber(tryWith);
            if (targetNumber == null) {
                targetNumber = factory.getSmallerNumber(tryWith);
            }
            tryWith = tryWith - targetNumber.getValue();
            Integer noOfOcc = roNumber.get(targetNumber) == null ? 0 : roNumber.get(targetNumber);
            noOfOcc++;
            if (targetNumber instanceof SuccessiveRepeatableRomanNumber) {
                if (noOfOcc == ((SuccessiveRepeatableRomanNumber) targetNumber).getTimes()) {
                    roNumber.clear();
                    break;
                }
            }
            roNumber.put(targetNumber, noOfOcc);
        }
        if (roNumber.size() != 0) {
            for (Map.Entry<RomanNumber, Integer> entry : roNumber.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    numbrList.add(entry.getKey());
                }
            }
            return numbrList;
        }
        tryWith = number;
        while (tryWith != 0) {
            RomanNumber targetNumber = factory.getNumber(tryWith);
            if (targetNumber == null) {
                targetNumber = factory.getGreaterNumber(tryWith);
            }
            tryWith = targetNumber.getValue() - tryWith;
            Integer noOfOcc = roNumber.get(targetNumber) == null ? 0 : roNumber.get(targetNumber);
            noOfOcc++;
            if (targetNumber instanceof SuccessiveRepeatableRomanNumber) {
                if (noOfOcc == ((SuccessiveRepeatableRomanNumber) targetNumber).getTimes()) {
                    System.out.println("Could not locate tata");
                    roNumber.clear();
                    break;
                }
            }
            roNumber.put(targetNumber, noOfOcc);
        }
        for (Map.Entry<RomanNumber, Integer> entry : roNumber.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                numbrList.add(entry.getKey());
            }
        }
        return numbrList;
    }


    public List<Integer> getClosestNumber(int value) {
        System.out.println(factory.numberCache);
        return null;
    }


}
