package com.example.bibliotheque.demo.common.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.stream.Stream;

public class Utils {
    public static String[] getNullPropertyNames(Object source) {
        // Check if source is null
        if (source == null) {
            throw new IllegalArgumentException("Source object must not be null");
        }
        // PropertyDescriptor h
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Stream.of(src.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(name -> src.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }

}
