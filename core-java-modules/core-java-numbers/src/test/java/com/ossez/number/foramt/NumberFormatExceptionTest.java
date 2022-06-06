package com.ossez.number.foramt;


import org.apache.commons.lang3.math.NumberUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * String format to number with NumberFormatException
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class NumberFormatExceptionTest {


    String stringPassword = "password";
    char[] charPassword = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

    @Test
    public void ConstructorNumberFormatException() {

//        JUNIT 5 Assert
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            new Integer("one");
        });
        System.out.println(exception);

//        AssertJ assertThatThrownBy
        assertThatThrownBy(() -> {
            new Integer("one");
        }).isInstanceOf(NumberFormatException.class).hasMessageStartingWith("For input string");

        // AssertJ assertThatExceptionOfType
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            new Integer("one");
        });


//		Integer aIntegerObj = new Integer("one");
//        Double doubleDecimalObj = new Double("two.2");
    }


}
