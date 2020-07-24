package com.ossez.codebank.interview.tests.others;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * For Minimum Coins
 *
 * @author YuCheng
 */
public class MinimumCoinsTest {

    private final static Logger logger = LoggerFactory.getLogger(MinimumCoinsTest.class);

    /**
     * https://www.cwiki.us/display/ITCLASSIFICATION/Minimum+Coins
     */
    @Test
    public void testMinimumCoins() {

        String line = "20";

        long coinsCount = 0;

        Long coinsValue = Long.parseLong(line);
        coinsCount = coinsValue / 5;
        Long coinsValueAfter5 = coinsValue % 5;

        if (coinsValueAfter5 == 4 || coinsValueAfter5 == 2)
            coinsCount = coinsCount + 2;
        else if (coinsValueAfter5 == 3 || coinsValueAfter5 == 1)
            coinsCount = coinsCount + 1;

        logger.debug("count Number > {}",coinsCount);
    }

}
