package com.ossez.toolkits.codebank.tests.lintcode;

import com.ossez.toolkits.codebank.tests.EmptyQuickTest;
import org.apache.commons.math3.util.FastMath;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 35
 * <ul>
 * <li>@see
 * <a href= "https://www.lintcode.com/problem/reverse-linked-list/description">https://www.lintcode.com/problem/reverse-linked-list/description</a>
 * <li>@see<a href= "https://www.lintcode.com/problem/reverse-linked-list/description">https://www.lintcode.com/problem/reverse-linked-list/description</a>
 * </ul>
 * </p>
 *
 * @author YuCheng
 */

public class LintCode0035BitOperationTest {

    private final static Logger logger = LoggerFactory.getLogger(EmptyQuickTest.class);

    /**
     * 35
     */
    @Test
    public void testInt2Bit() {
        logger.debug("BEGIN");
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(2));

        System.out.println(Integer.toBinaryString(2 << 2));

        System.out.println(Integer.parseInt(Integer.toBinaryString(2 << 2), 2));

        System.out.println(5 / 3);
        System.out.println(5 % 3);
        FastMath.pow(2, 3);

    }

}
