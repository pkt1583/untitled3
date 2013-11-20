package com.example.creators;

import com.example.model.RomanNumber;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractRomanNumberFactory {

    public Map<RomanNumber, Integer> numberCache = new TreeMap<RomanNumber, Integer>(new Comparator<RomanNumber>() {
        @Override
        public int compare(RomanNumber o1, RomanNumber o2) {
            return o1.getValue() > o2.getValue() ? 1 : -1;
        }
    });

    private static AbstractRomanNumberFactory fact = new AbstractRomanNumberFactory();

    public static AbstractRomanNumberFactory getInstance() {
        if (fact == null) {
            fact = new AbstractRomanNumberFactory();
        }
        return fact;
    }

    private AbstractRomanNumberFactory() {

    }

    public RomanNumber getNumberFor(int value, int noOfOccurance, NumberCreator creator) {
        RomanNumber number = getFromCache(value);
        if (number == null) {
            number = performAction(noOfOccurance, creator);
            number.setValue(value);
            putIntoCache(value, number);
        }
        return number;
    }

    private RomanNumber performAction(int noOfOccurance, NumberCreator creator) {
        RomanNumber number = createInstance(noOfOccurance, creator);
        return number;
    }

    private void putIntoCache(int value, RomanNumber number) {
        numberCache.put(number, value);
    }

    protected RomanNumber getFromCache(int value) {
        for (Map.Entry<RomanNumber, Integer> entry : numberCache.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected RomanNumber createInstance(int noOfOcurance, NumberCreator creator) {
        return creator.createInstance(noOfOcurance);
    }

    ;


}
