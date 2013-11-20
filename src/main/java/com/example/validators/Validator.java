package com.example.validators;

import com.example.model.RomanNumber;

import java.util.Map;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Validator {
    Map<Object, Object> validate(RomanNumber... numbers);
}
