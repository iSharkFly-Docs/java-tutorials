package com.ossez.toolkits.codebank.tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;
import java.util.stream.Collectors;

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
        List<String> testList = new ArrayList<>();


        testList.add(String.valueOf(1L));
        testList.add("iSharkFly");
        testList.add(String.valueOf(2));
        testList.forEach(e -> log.debug("{}", e));


        String index0 = (String) testList.get(0);
        String index1 = (String) testList.get(1);
    }

}
