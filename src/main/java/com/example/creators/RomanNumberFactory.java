package com.example.creators;

import com.example.model.RomanNumber;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomanNumberFactory implements NumberCreator {
    @Override
    public RomanNumber createInstance(int noOfOcurance) {
        return new RomanNumber();
    }
}
