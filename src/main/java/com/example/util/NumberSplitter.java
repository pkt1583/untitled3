package com.example.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: pankaj
 */
public class NumberSplitter {

    public static void getSplitNumberAndPutToList(int num, List<Integer> returnList) {
        if (num != 0) {
            int value = num % 10;
            returnList.add(num % 10);
            num = num / 10;
            getSplitNumberAndPutToList(num, returnList);
        }
    }

    public static List<Integer> addRequiredZeros(List<Integer> inputList) {
        List<Integer> elements = new ArrayList<Integer>();
        for (int i = 0; i < inputList.size(); i++) {
            int value = inputList.get(i);
            for (int j = 0; j < i; j++) {
                value = value * 10;
            }
            if (value != 0) {
                elements.add(value);
            }
        }
        Collections.reverse(elements);
        return elements;
    }

}
