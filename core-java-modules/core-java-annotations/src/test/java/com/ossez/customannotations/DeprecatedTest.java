package com.ossez.customannotations;

import com.ossez.annotations.ClassWithDeprecatedMethod;
import org.junit.jupiter.api.Test;

public class DeprecatedTest {

    @Test
    public void testStrikesWarning() {
        ClassWithDeprecatedMethod.deprecatedMethod();
    }

}
