package com.ossez.toolkits.codebank.tests.interview;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * For Lambda Evens
 *
 * @author YuCheng
 */
public class LambdaEvensTest {

    private final static Logger logger = LoggerFactory.getLogger(LambdaEvensTest.class);

    /**
     * Lambda Function
     */

    interface Arithmetic {
        Long operation(Long a, Long b);
    }


    /**
     * https://www.cwiki.us/display/ITCLASSIFICATION/Lambda+Evens
     */
    @Test
    public void testLambdaEvents() {

        String line = "1 2 3 4 5 6 ";

        String[] lineArray = line.split(" ");
        List<Long> numbers = new ArrayList<>();
        Arithmetic division = (Long a, Long b) -> (a % b);


        for (String lineChar : lineArray) {
            if (division.operation(Long.parseLong(lineChar), 2L) == 0) {
                System.out.print(lineChar + " ");
//				logger.debug(lineChar + " ");
            }
        }

    }
}