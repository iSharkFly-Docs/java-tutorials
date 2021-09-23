package com.ossez.toolkits.codebank.tests.algorithm;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
     * Prime Number Check Test
     */
    @Test
    public void testIsPrime() {
        int number = 10;
        Boolean isPrime = number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));

        logger.debug(" {} Prime CORE Check is - [{}]", number, isPrime);
        logger.debug(" {} Prime BigInteger Check is - [{}]", number, BigInteger.valueOf(number).isProbablePrime(100));
        logger.debug(" {} Prime APACHE MATH3 Check is - [{}]", number, Primes.isPrime(number));
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

