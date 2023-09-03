package com.ossez.toolkits.codebank.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * Empty Test Case
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class EmptyQuickTest {

    @BeforeEach
    protected void setUp() throws Exception {
    }

    @AfterEach
    protected void tearDown() throws Exception {
    }

    @Test
    public void testMain() {

        log.info("TEST MAIN - BEGIN");

    }

}
