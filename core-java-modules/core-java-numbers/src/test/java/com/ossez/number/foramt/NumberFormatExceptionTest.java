package com.ossez.number.foramt;


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class NumberFormatExceptionTest {


    String stringPassword = "password";
    char[] charPassword = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

    @Test
    public void ConstructorNumberFormatException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            new Integer("one");
        });

        System.out.println(exception);

		Integer aIntegerObj = new Integer("one");
        Double doubleDecimalObj = new Double("two.2");
    }



}
