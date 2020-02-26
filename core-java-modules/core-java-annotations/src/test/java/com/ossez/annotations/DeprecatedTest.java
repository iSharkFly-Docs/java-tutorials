package com.ossez.annotations;

import org.junit.jupiter.api.Test;

public class DeprecatedTest {

    @Test
    public void testStrikesWarning() {
        ClassWithDeprecatedMethod.deprecatedMethod();
    }

}
