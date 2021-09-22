package com.ossez.lcm;

import org.junit.Assert;
import org.junit.Test;

public class SimpleAlgorithmUnitTest {

    @Test
    public void testLCM() {
        Assert.assertEquals(36, lcm(12, 18));
    }

}
