package com.example.creators;

import com.example.model.RomanNumber;

import java.util.*;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractRomanNumberFactory {

    public TreeMap<Integer, RomanNumber> numberCache = new TreeMap<Integer, RomanNumber>();

    private static AbstractRomanNumberFactory fact = new AbstractRomanNumberFactory();

    public Map<Integer, RomanNumber> numberMapping = new HashMap<Integer, RomanNumber>();


    public static AbstractRomanNumberFactory getInstance() {
        if (fact == null) {
            fact = new AbstractRomanNumberFactory();
        }
        return fact;
    }

    private AbstractRomanNumberFactory() {

    }

    public RomanNumber getNumberFor(int value, int noOfOccurance, NumberCreator creator) {
        RomanNumber number = getNumber(value);
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
        numberCache.put(value, number);
    }

    public RomanNumber getNumber(int value) {
        return numberCache.get(value);
    }

    protected RomanNumber createInstance(int noOfOcurance, NumberCreator creator) {
        return creator.createInstance(noOfOcurance);
    }

    public RomanNumber getGreaterNumber(Integer value) {
        return numberCache.ceilingEntry(value).getValue();
    }

    public List<RomanNumber> findAndPopulate(Integer number) {
        List<RomanNumber> numbers = new ArrayList<RomanNumber>();
        RomanNumber smallerThenCurrent = numberCache.floorEntry(number).getValue();
        numbers.add(smallerThenCurrent);
        Integer diff = number - smallerThenCurrent.getValue();
        for (Map.Entry<Integer, RomanNumber> entry : numberCache.entrySet()) {
            if (diff != 0) {
                if (entry.getValue().isMultipleOf(diff)) {
                    for (int i = 0; i < diff; i++) {
                        numbers.add(entry.getValue());
                        i = i + entry.getKey();
                    }
                    break;
                }
            }
        }
        return numbers;
    }

    public RomanNumber getSmallerNumber(int number) {
        return numberCache.floorEntry(number).getValue();
    }
}
