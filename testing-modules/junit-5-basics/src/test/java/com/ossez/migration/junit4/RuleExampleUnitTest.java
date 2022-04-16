package com.ossez.migration.junit4;

import com.ossez.migration.junit4.rules.TraceUnitTestRule;
import org.junit.Rule;
import org.junit.Test;

public class RuleExampleUnitTest {

    @Rule
    public final TraceUnitTestRule traceRuleTests = new TraceUnitTestRule();

    @Test
    public void whenTracingTests() {
        System.out.println("This is my test");
        /*...*/
    }
}
