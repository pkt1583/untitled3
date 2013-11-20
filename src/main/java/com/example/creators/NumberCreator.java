package com.example.creators;

import com.example.model.RomanNumber;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface NumberCreator {
    public RomanNumber createInstance(int noOfOccurance);
}
