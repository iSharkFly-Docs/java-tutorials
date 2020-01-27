package com.ossez.lang.tutorial.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * variable arguments use case
 */
public class VarargsCase {
    private static final Logger logger = LoggerFactory.getLogger(VarargsCase.class);

    /**
     * sumVarargs
     *
     * @param intArrays
     * @return
     */
    static int sumVarargs(int... intArrays) {
        int sum, i;
        sum = 0;
        for (i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return (sum);
    }

    /**
     * Main Function
     *
     * @param args
     */
    public static void main(String args[]) {
        int sum = 0;
        sum = sumVarargs(new int[]{10, 12, 33, 7});
        logger.debug("The Sum of the arrays: {}", sum);
    }
}
