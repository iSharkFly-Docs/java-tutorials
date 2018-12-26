package com.ossez.codebank.algorithm.tests.lintcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.algorithm.models.ListNode;

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
public class LintCode0102HasCycleTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0102HasCycleTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		// INIT LINKED LIST
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		// CREATE A LOOP
		head.next.next.next.next = head.next.next.next;

		boolean retResult = false;

		// LIKED LIST MAY NULL:
		if (!(head == null || head.next == null)) {
			ListNode s = head;
			ListNode f = head.next;

			while (f.next != null && f.next.next != null) {

				s = s.next;
				f = f.next.next;

				if (f == s) {
					retResult = true;
					break;
				}
			}
		}

		System.out.println(retResult);

	}
}
