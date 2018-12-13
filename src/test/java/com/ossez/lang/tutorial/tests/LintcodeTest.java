package com.ossez.lang.tutorial.tests;

import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;

import junit.framework.TestCase;

/**
 * 
 * @author YuCheng
 *
 */
public class LintcodeTest extends TestCase {

	private final static Logger logger = LoggerFactory.getLogger(LintcodeTest.class);

	/**
	 * 53 https://www.lintcode.com/problem/reverse-words-in-a-string/description
	 */
	public void testReverseWords() {

		String s = "  Life  doesn't  always    give     us  the       joys we want.";

		String retStr = "";
		String[] inStr = s.split(" ");

		for (int i = inStr.length - 1; i >= 0; i--) {
			String cStr = inStr[i].trim();
			if (!cStr.isEmpty()) {
				retStr = retStr + " " + cStr;
			}
		}
		retStr = retStr.trim();
		System.out.println(retStr);
		// return retStr;

	}

	/**
	 * 767 https://www.lintcode.com/problem/reverse-array/description
	 */
	public void testReverseArray() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < nums.length / 2; i++) {
			int tmp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = tmp;
		}
		
		System.out.println(Arrays.toString(nums));

	}

}
