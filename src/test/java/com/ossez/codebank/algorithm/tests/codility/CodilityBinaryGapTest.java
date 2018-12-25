package com.ossez.codebank.algorithm.tests.codility;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 *
 */
public class CodilityBinaryGapTest {

	private final static Logger logger = LoggerFactory.getLogger(CodilityBinaryGapTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");

		int N = 529;
		String intStr = Integer.toBinaryString(N);

		intStr = intStr.replace("1", "#1#");

		String[] strArray = intStr.split("1");

		int maxCount = 0;
		for (int i = 0; i < strArray.length; i++) {
			String checkStr = strArray[i];
			int countLength = 0;

			if (checkStr.length() > 2 && checkStr.startsWith("#") && checkStr.endsWith("#")) {
				checkStr = checkStr.replace("#", "");
				countLength = checkStr.length();

				if (maxCount < countLength) {
					maxCount = countLength;
				}

			}
		}

		logger.debug("MAX COUNT: [{}]", maxCount);
	}

}
