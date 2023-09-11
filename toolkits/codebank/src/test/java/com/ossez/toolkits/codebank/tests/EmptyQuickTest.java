package com.ossez.toolkits.codebank.tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

/**
 * String Test Case
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class EmptyQuickTest {
    private static final String VOWEL_A = "a";
    private static final String VOWEL_E = "e";
    private static final String VOWEL_I = "i";
    private static final String VOWEL_O = "o";
    private static final String VOWEL_U = "u";


    @BeforeEach
    protected void setUp() throws Exception {
    }

    @AfterEach
    protected void tearDown() throws Exception {
    }

    @Test
    public void testMain() {

        String strTransform = "AI is driving the world crazy";

        List<String> test = List.of(StringUtils.split(strTransform, " "));

        for (int i = 0; i < test.size(); i++) {
            if (hasVowels(test.get(i))) {
                log.debug("Vowel STR - {}", test.get(i));
            }

        }
    }

    private Boolean hasVowels(String str) {

        str = StringUtils.trimToEmpty(str);
        str = StringUtils.lowerCase(str);
        str = StringUtils.remove(str, " ");

        if (StringUtils.contains(str, VOWEL_A)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_E)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_I)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_O)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_U)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
