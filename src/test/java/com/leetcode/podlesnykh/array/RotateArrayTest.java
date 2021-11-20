package com.leetcode.podlesnykh.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;


public abstract class RotateArrayTest {

    protected RotateArray sut;

    abstract void setUp();

    @ParameterizedTest()
    @CsvFileSource(resources = "/rotate-array-data.csv",
            delimiter = ',',
            numLinesToSkip = 1)
    void testRotate(@ConvertWith(TestIntegerArrayConverter.class) int [] array,
                            int steps,
                            @ConvertWith(TestIntegerArrayConverter.class) int [] expectedArray) {
        sut.rotate(array, steps);

        Assertions.assertArrayEquals(expectedArray, array);
    }
}
