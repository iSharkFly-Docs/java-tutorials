package com.ossez.codebank.interview.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For Wayfair
 * 
 * @author YuCheng
 *
 */
public class WayfairTest {

	private final static Logger logger = LoggerFactory.getLogger(WayfairTest.class);

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Build+Castles
	 */
	@Test
	public void testBuildCastles() {

		// int[] A = { -3, -3 };
		int[] A = { 2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5 };

		int h = 0;
		int v = 0;

		List<Integer> nList = new ArrayList<Integer>();

		// Rebuild List
		nList.add(A[0]);
		for (int i = 0; i < A.length - 1; i++) {

			if (A[i] != A[i + 1]) {
				nList.add(A[i + 1]);
			}

		}

		// LOOP List to find right location
		for (int i = 0; i < nList.size() - 1; i++) {

			// COUNT 0
			if (i == 0) {
				if (nList.get(i) < nList.get(i + 1)) {
					v++;
				}
			} else {
				if (nList.get(i) < nList.get(i - 1) && nList.get(i) < nList.get(i + 1)) {
					v++;
				}

				if (nList.get(i) > nList.get(i - 1) && nList.get(i) > nList.get(i + 1)) {
					h++;
				}
			}
		}

		if (nList.size() == 1) {
			h++;
		} else if (nList.size() > 2 && nList.get(nList.size() - 1) > nList.get(nList.size() - 2)) {
			h++;
		}

		// CHECK
		logger.debug("V - [{}]", v);
		logger.debug("H - [{}]", h);

		logger.debug("H + V - [{}]", (h + v));

	}

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Binomial+Coefficient
	 * 
	 * Binomial Coefficient
	 */
	@Test
	public void testBinomialCoefficient() {
		int n = 40;
		int k = 20;

		BigDecimal bc = factorial(n).divide(factorial(k).multiply(factorial(n - k)));
		// a.compareTo(new BigDecimal(1000000000))
		logger.debug("{}", bc);
		logger.debug("Check for Compare To - [{}]", bc.compareTo(new BigDecimal(1000000000)));
		logger.debug("Value - [{}]", bc);

		logger.debug("Apache CombinatoricsUtils Factorial - [{}]", CombinatoricsUtils.factorialDouble(20));
		logger.debug("Apache CombinatoricsUtils Binomial Coefficient - [{}]", CombinatoricsUtils.binomialCoefficientDouble(40, 20));

	}

	/**
	 * for factorial
	 * 
	 * @param x
	 * @return
	 */
	private static BigDecimal factorial(int x) {
		if (x == 1 || x == 0) {
			return BigDecimal.valueOf(1);
		} else {
			return BigDecimal.valueOf(x).multiply(factorial(x - 1));
		}
	}

}
