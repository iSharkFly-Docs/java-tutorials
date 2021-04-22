package com.ossez.toolkits.codebank.tests.leetcode;

import com.ossez.toolkits.codebank.common.model.TreeNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * <p>
 * 7
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Serialize+and+Deserialize+Binary+Tree">https://www.cwiki.us/display/ITCLASSIFICATION/Serialize+and+Deserialize+Binary+Tree</a>
 * <li>@see<a href=
 * "https://leetcode.com/problems/first-unique-character-in-a-string/">https://leetcode.com/problems/first-unique-character-in-a-string/</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LeetCode0387FirstUniqueCharacterTest {

	private final static Logger logger = LoggerFactory.getLogger(LeetCode0387FirstUniqueCharacterTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		String data = "leetcode";

		System.out.println(firstUniqChar(data));

	}

	/**
	 * Deserialize from array to tree
	 * 
	 * @param data
	 * @return
	 */
	private int firstUniqChar(String data) {
		// NULL CHECK
		if (data.equals("")) {
			return -1;
		}


		return 0;

	}



}
