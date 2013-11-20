package com.example.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pankaj
 */
//TODO: Correct the test case
public class NumberSplitterTest {
    @Test
    public void testGetSplitNumber() throws Exception {
        NumberSplitter numberSplitter = new NumberSplitter();
        List<Integer> returnList = new ArrayList<Integer>();
        numberSplitter.getSplitNumberAndPutToList(1904, returnList);
        System.out.println(numberSplitter.addRequiredZeros(returnList));
    }
}
