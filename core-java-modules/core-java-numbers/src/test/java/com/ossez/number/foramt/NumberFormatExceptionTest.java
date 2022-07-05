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
 * <p><a href="https://www.ossez.com/t/java-numberformatexception/13986">https://www.ossez.com/t/java-numberformatexception/13986</a></p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class NumberFormatExceptionTest {

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
//      Double doubleDecimalObj = new Double("two.2");
    }


}
