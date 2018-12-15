package com.ossez.lang.tutorial.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.ListenerNotFoundException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.lang.tutorial.models.ListNode;

/**
 * 
 * @author YuCheng
 *
 */
public class LintcodeTest {

	private final static Logger logger = LoggerFactory.getLogger(LintcodeTest.class);

	/**
	 * 35 https://www.lintcode.com/problem/reverse-linked-list/description
	 */
	@Test
	public void test0035Reverse() {
		// INIT LINKED LIST
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		// CHECK BEFORE
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);

		// REVERSE
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		// CHECK AFTER
		System.out.println(prev.val);
		System.out.println(prev.next.val);
		System.out.println(prev.next.next.val);
	}

	/**
	 * 1480 https://www.lintcode.com/problem/dot-product/description
	 */
	@Test
	public void test0044minSubArray() {

		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(1);

		int min_ending_here = 0;
		int retStatus = 0;

		for (int i = 0; i < nums.size(); i++) {
			if (min_ending_here > 0) {
				min_ending_here = nums.get(i);
			} else {
				min_ending_here += nums.get(i);
			}
			retStatus = Math.min(retStatus, min_ending_here);
		}

		System.out.println(retStatus);

	}

	/**
	 * 53 https://www.lintcode.com/problem/reverse-words-in-a-string/description
	 */
	@Test
	public void test0053ReverseWords() {

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
	 * 56 https://www.lintcode.com/problem/two-sum/description
	 */
	@Test
	public void test0056TwoSum() {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;

		int[] retArray = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			int intA = numbers[i];
			int intB = 0;

			for (int j = 1 + i; j < numbers.length; j++) {
				intB = numbers[j];
				// SUM CHECK
				if (target == intA + intB && i < j) {
					retArray[0] = i;
					retArray[1] = j;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(retArray));
	}

	/**
	 * 209 https://www.lintcode.com/problem/first-unique-character-in-a-string
	 */
	@Test
	public void test0209FirstUniqChar() {
		String str = "ddjdz";

		char retStatus = 0;

		// LOOP CHECK
		for (int i = 0; i < 30; i++) {
			char c = str.charAt(0);
			if (str.indexOf(Character.toString(c)) == str.lastIndexOf(Character.toString(c))) {
				retStatus = c;
				break;
			}
			str = str.replaceAll(Character.toString(c), "");
		}

		System.out.println("" + retStatus);
	}

	/**
	 * 411
	 * 
	 * <p>
	 * <ul>
	 * <li>@see
	 * <a href="https://www.cwiki.us/display/ITCLASSIFICATION/Gray+Code">https://www.cwiki.us/display/ITCLASSIFICATION/Gray+Code</a>
	 * <li>@see<a href="https://www.lintcode.com/problem/gray-code/description">https://www.lintcode.com/problem/gray-code/description</a>
	 * </ul>
	 * </p>
	 * 
	 */
	@Test
	public void test0411GrayCode() {
		int n = 2;

		List<Integer> retArray = new ArrayList<>();

		if (n == 0) {
			retArray.add(0);
		}

		for (int i = 0; i < (2 << (n - 1)); i++) {
			int g = i ^ (i / 2);
			retArray.add(g);
		}

		System.out.println(retArray);
	}

	/**
	 * 1480 https://www.lintcode.com/problem/dot-product/description
	 */
	@Test
	public void test0423IsValidParentheses() {
		String s = "([)]";

		boolean retStatus = false;
		for (int i = 0; i < 3; i++) {
			s = s.replace("()", "");
			s = s.replace("{}", "");
			s = s.replace("[]", "");

			if (s.length() == 0) {
				retStatus = true;
				break;
			}
		}

		System.out.println(retStatus);

	}

	/**
	 * 646 https://www.lintcode.com/problem/first-position-unique-character/description
	 */
	@Test
	public void test0646FirstUniqChar() {
		String s = "saau";

		int retStatus = -1;
		boolean breakLoop = false;

		int[] iArray = new int[256];

		// NULL CHECK
		if (s == null || s.length() == 0) {
			retStatus = -1;
		}

		// LOOP CHECK
		for (char c : s.toCharArray()) {
			iArray[c]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (iArray[s.charAt(i)] == 1) {
				retStatus = i;
				breakLoop = true;
				break;
			}
		}

		// LOOP BREAK CHECK
		if (!breakLoop) {
			retStatus = -1;
		}

		System.out.println(retStatus);
	}

	/**
	 * 767 https://www.lintcode.com/problem/reverse-array/description
	 */
	@Test
	public void test0767ReverseArray() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < nums.length / 2; i++) {
			int tmp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = tmp;
		}

		System.out.println(Arrays.toString(nums));

	}

	/**
	 * 1480 https://www.lintcode.com/problem/dot-product/description
	 */
	@Test
	public void test1377findSubstring() {
		String str = "";
		int k = 5;

		HashSet<String> strSet = new HashSet<String>();

		for (int i = 0; i <= str.length() - k; i++) {
			String subStr = str.substring(i, i + k);

			String pattern = ".*(.).*\\1.*";

			Pattern r = Pattern.compile(pattern);

			Matcher m = r.matcher(subStr);
			if (!m.find()) {
				strSet.add(subStr);
			}

		}

		System.out.println(strSet.size());
	}

	/**
	 * 1480 https://www.lintcode.com/problem/dot-product/description
	 */
	@Test
	public void test1480dotProduct() {
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
