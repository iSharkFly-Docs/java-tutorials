package com.ossez.codebank.interview.tests;

import java.util.HashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For Tenna
 * 
 * @author YuCheng
 *
 */
public class TennaTest {

	private final static Logger logger = LoggerFactory.getLogger(TennaTest.class);

	/**
	 * Optimized Math
	 */
	@Test
	public void testOptimizedMath() {

		HashMap<Integer, String> outMap = new HashMap<Integer, String>();

		// LOOP SET VALUE TO MAP
		for (int i = 1; i <= 100; i++) {
			if (outMap.get(i) == null && i % 2 == 0 && i % 3 == 0) {
				outMap.put(i, "divisible by two and three.");
			} else if (outMap.get(i) == null && i % 3 == 0) {
				outMap.put(i, "divisible by three.");
			} else if (outMap.get(i) == null && i % 2 == 0) {
				outMap.put(i, "even.");
			} else {
				outMap.put(i, "odd.");
			}
		}

		// LOOP FOR OUTPUT
		for (int i = 1; i <= 100; i++) {
			logger.debug("The number '{}' is {} ", i, outMap.get(i));
		}

	}
}
