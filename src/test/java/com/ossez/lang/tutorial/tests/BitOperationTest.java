package com.ossez.lang.tutorial.tests;

import org.apache.commons.math3.util.FastMath;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author YuCheng
 *
 */
public class BitOperationTest {

	private final static Logger logger = LoggerFactory.getLogger(BitOperationTest.class);

	/**
	 * 35 https://www.lintcode.com/problem/reverse-linked-list/description
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
