package com.ossez.toolkits.codebank.tests.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Prime numbers from 1 to 100
 * <ul>
 * <li>@see <a href= "https://www.ossez.com/t/prime-numbers-from-1-to-100-100/13450">https://www.ossez.com/t/prime-numbers-from-1-to-100-100/13450</a>
 * </li>
 * </ul>
 * </p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrimeNumbersTest {

    private final static Logger logger = LoggerFactory.getLogger(PrimeNumbersTest.class);

    /**
     *
     */
    @Test
    public void testMain() {
        logger.debug("BEGIN");

        int N = 100;
        List<Integer> primeNumberList = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (isPrimeNumber(i))
                primeNumberList.add(i);
        }

        logger.debug("primeNumber Count -[{}]", primeNumberList.size());
        logger.debug("primeNumber Count -[{}]", primeNumberList);
    }

    /**
     * @param number
     * @return
     */
    private boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

