package com.ossez.lang.tutorial.tests.lintcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 1480
 * <ul>
 * <li>@see
 * <a href= "https://www.cwiki.us/display/ITCLASSIFICATION/Dot+Product">https://www.cwiki.us/display/ITCLASSIFICATION/Dot+Product</a>
 * <li>@see<a href= "https://www.lintcode.com/problem/dot-product/">https://www.lintcode.com/problem/dot-product/</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode1480DotProductTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode1480DotProductTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		int[] A = { 1, 1, -1 };
		int[] B = { 2147483647, 1, 3 };

		int retStatus = 0;

		// LENGTH CHECK
		if (A.length == 0 || B.length == 0 || A.length != B.length)
			retStatus = -1;

		// ADDED
		if (retStatus != -1) {
			for (int i = 0; i < A.length; i++) {
				retStatus = retStatus + A[i] * B[i];
			}
		}

		System.out.println(retStatus);
	}

}
