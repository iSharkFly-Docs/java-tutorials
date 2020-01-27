package com.ossez.lang.tutorial.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VarargsCase {
    private static final Logger logger = LoggerFactory.getLogger(VarargsCase.class);

    /**
     * @param intArrays
     * @return
     */
    static int sumvarargs(int... intArrays) {
        int sum, i;
        sum = 0;
        for (i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return (sum);
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        int sum = 0;
        sum = sumvarargs(new int[]{10, 12, 33});
        logger.debug("The Sum of the arrays: {}", sum);
    }
}
