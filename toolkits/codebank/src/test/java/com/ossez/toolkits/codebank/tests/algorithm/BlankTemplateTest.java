package com.ossez.toolkits.codebank.tests.algorithm;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YuCheng
 */
public class BlankTemplateTest extends TestCase {

    private final static Logger logger = LoggerFactory.getLogger(BlankTemplateTest.class);

    /**
     * Blank Template Test
     */
    @Test
    public void testBlank() {

        Integer[] inputArrayB = {3, 7, 1, 2, 8, 4, 5};
        List<Integer> inListA = Arrays.asList(inputArrayB);

        int[] inputArrayA = {3, 7, 1, 2, 8, 4, 5};
        List<Integer> inList = Arrays.stream(inputArrayA).sorted().boxed().collect(Collectors.toList());


        for (int i = 0; i < 8; i++) {
            if (!inListA.contains(i)) {
                System.out.println(i);
            }

        }


        System.out.println((int)'E');
        System.out.println((byte)0xFF);

    }

}
