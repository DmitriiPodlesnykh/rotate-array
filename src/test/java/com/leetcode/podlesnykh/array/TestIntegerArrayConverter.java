package com.leetcode.podlesnykh.array;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;

public class TestIntegerArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String
                && int[].class.isAssignableFrom(targetType)) {
            return convert(String.valueOf(source));
        }
        throw new IllegalArgumentException();
    }

    private Object convert(String source) throws ArgumentConversionException {
        final String stringSource = String.valueOf(source);
        final String[] splitString = stringSource.split(" ");
        return Arrays.stream(splitString).mapToInt(Integer::valueOf).toArray();
    }

}
