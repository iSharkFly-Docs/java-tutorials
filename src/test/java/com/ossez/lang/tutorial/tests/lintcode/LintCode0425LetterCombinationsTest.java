package com.ossez.lang.tutorial.tests.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 425
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Letter+Combinations+of+a+Phone+Number">https://www.cwiki.us/display/ITCLASSIFICATION/Letter+Combinations+of+a+Phone+Number</a>
 * <li>@see<a href=
 * "https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description">https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode0425LetterCombinationsTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0425LetterCombinationsTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("LetterCombinationsTest");
		String digits = "23";

		HashMap<String, String> phoneKeyMap = new HashMap<String, String>();
		phoneKeyMap.put("0", "");
		phoneKeyMap.put("1", "");
		phoneKeyMap.put("2", "abc");
		phoneKeyMap.put("3", "def");
		phoneKeyMap.put("4", "ghi");
		phoneKeyMap.put("5", "jkl");
		phoneKeyMap.put("6", "mno");
		phoneKeyMap.put("7", "pqrs");
		phoneKeyMap.put("8", "tuv");
		phoneKeyMap.put("9", "wxyz");

		List<String> retStatus = new ArrayList<>();

		if (digits != null && digits.length() != 0) {
			phoneRecursive(digits, retStatus, phoneKeyMap, "", 0);
		}

		System.out.println(retStatus);
	}

	/**
	 * phoneRecursive
	 * 
	 * @param digits
	 * @param retStatus
	 * @param phoneKeyMap
	 * @param comb
	 * @param index
	 */
	private void phoneRecursive(String digits, List<String> retStatus, HashMap<String, String> phoneKeyMap, String comb, int index) {
		if (index == digits.length()) {
			retStatus.add(comb);
			return;
		}

		char pos = digits.charAt(index);
		for (char c : ((String) phoneKeyMap.get(String.valueOf(pos))).toCharArray()) {
			phoneRecursive(digits, retStatus, phoneKeyMap, comb + c, index + 1);
		}
	}
}
