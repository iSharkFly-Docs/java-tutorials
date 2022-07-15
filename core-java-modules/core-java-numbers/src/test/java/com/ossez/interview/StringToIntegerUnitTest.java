package com.ossez.interview;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToIntegerUnitTest {
    @Test
    public void givenString_whenParsingInt_shouldConvertToInt() {
        String givenString = "42";

        int result = Integer.parseInt(givenString);

        assertThat(result).isEqualTo(42);
    }
}
