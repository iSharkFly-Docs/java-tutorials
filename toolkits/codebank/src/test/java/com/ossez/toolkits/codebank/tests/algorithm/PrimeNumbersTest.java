package com.ossez.toolkits.codebank.tests.algorithm;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * More details about question see link below
 * <ul>
 * <li>@see <a href= "https://www.cwiki.us/display/ITCLASSIFICATION/Binary+Gap">https://www.cwiki.us/display/ITCLASSIFICATION/Binary+Gap</a>
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
    public boolean isPrimeNumber(int number) {
    	System.out.println(5%3);;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

