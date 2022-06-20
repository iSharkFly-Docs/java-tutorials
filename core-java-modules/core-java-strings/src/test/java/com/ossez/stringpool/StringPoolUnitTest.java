package com.ossez.stringpool;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringPoolUnitTest {

    private static Logger logger = LoggerFactory.getLogger(StringPoolUnitTest.class);

    @Test
    public void whenCreatingConstantStrings_thenTheirAddressesAreEqual() {
        String constantString1 = "HoneyMoose";
        String constantString2 = "HoneyMoose";

        assertThat(constantString1).isSameAs(constantString2);
    }

    @Test
    public void whenCreatingStringsWithTheNewOperator_thenTheirAddressesAreDifferent() {
        String newString1 = new String("HoneyMoose");
        String newString2 = new String("HoneyMoose");

        assertThat(newString1).isNotSameAs(newString2);

        logger.info("newString1 Address: {}", System.identityHashCode(newString1));
        logger.info("newString2 Address: {}", System.identityHashCode(newString2));
    }

    @Test
    public void whenComparingConstantAndNewStrings_thenTheirAddressesAreDifferent() {
        String constantString = "HoneyMoose";
        String newString = new String("HoneyMoose");

        assertThat(constantString).isNotSameAs(newString);
    }

    @Test
    public void whenInterningAStringWithIdenticalValueToAnother_thenTheirAddressesAreEqual() {
        String constantString = "interned HoneyMoose";
        String newString = new String("interned HoneyMoose");

        assertThat(constantString).isNotSameAs(newString);

        String internedString = newString.intern();

        assertThat(constantString).isSameAs(internedString);
    }
}
