package com.andredias.udemy.util;

import org.springframework.stereotype.Component;

@Component
public class NumberConverter {

    public Number converter(String value){
        if(value == null) return null;

        value = value.replace(".", "").replace(",", ".");
        return Float.parseFloat(value);
    }
}
