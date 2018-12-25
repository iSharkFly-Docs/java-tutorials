package com.ossez.codebank.algorithm.tests.lintcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.lang.tutorial.models.ListNode;

/**
 * <p>
 * 102
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Linked+List+Cycle">https://www.cwiki.us/display/ITCLASSIFICATION/Linked+List+Cycle</a>
 * <li>@see<a href= "https://www.lintcode.com/problem/linked-list-cycle/">https://www.lintcode.com/problem/linked-list-cycle/</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode0165MergeTwoListsTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0165MergeTwoListsTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		// INIT LINKED LIST l1
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(11);
		l1.next.next.next.next = new ListNode(15);

		// INIT LINKED LIST l2
		ListNode l2 = new ListNode(2);

		// RETURN RESULT
		ListNode retResult = new ListNode(0);

		// NULL CHECK
		// if (l1 == null && l2 == null) {
		// retResult = null;
		// }
		//
		// if (l1 == null) {
		// retResult = l2;
		// }
		//
		// if (l2 == null) {
		// retResult = l1;
		// }

		// MERGE
		retResult = new ListNode(0);
		ListNode tmpNode = new ListNode(0);
		retResult = tmpNode;
		while (l1 != null & l2 != null) {
			if (l1.val <= l2.val) {
				tmpNode.next = l1;
				l1 = l1.next;
			} else {
				tmpNode.next = l2;
				l2 = l2.next;
			}

			tmpNode = tmpNode.next;
		}

		if (l1 == null) {
			tmpNode.next = l2;
		}

		if (l2 == null) {
			tmpNode.next = l1;
		}

		retResult = retResult.next;

		System.out.println(retResult.val);
		System.out.println(retResult.next.val);
		System.out.println(retResult.next.next.val);

	}
}
