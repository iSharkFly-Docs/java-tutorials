package com.ossez.argsVsvarargs;

import static com.ossez.argsVsvarargs.StringArrayAndVarargs.capitalizeNames;
import static com.ossez.argsVsvarargs.StringArrayAndVarargs.firstLetterOfWords;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringArrayAndVarargsUnitTest {

    @Test
    void whenCheckingArgumentClassName_thenNameShouldBeStringArray() {
        String[] names = {"john", "ade", "kofi", "imo"};
        assertNotNull(names);
        assertEquals("java.lang.String[]", names.getClass().getTypeName());
        capitalizeNames(names);
    }

    @Test
    void whenCheckingReturnedObjectClass_thenClassShouldBeStringArray() {
        assertEquals(String[].class, firstLetterOfWords("football", "basketball", "volleyball").getClass());
        assertEquals(3, firstLetterOfWords("football", "basketball", "volleyball").length);
    }
}