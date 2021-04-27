package com.ossez.toolkits.codebank.tests.leetcode;

import com.ossez.toolkits.codebank.common.model.TreeNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 7
 * <ul>
 * <li>@see <a href=
 * "https://www.ossez.com/t/first-unique-character-in-a-string/13448">First Unique Character in a String (找到一个字符串中第一个不重复的字符)</a>
 * <li>@see<a href=
 * "https://leetcode.com/problems/first-unique-character-in-a-string/">https://leetcode.com/problems/first-unique-character-in-a-string/</a>
 * </ul>
 * </p>
 *
 * @author YuCheng
 */
public class LeetCode0387FirstUniqueCharacterTest {

    private final static Logger logger = LoggerFactory.getLogger(LeetCode0387FirstUniqueCharacterTest.class);

    /**
     *
     */
    @Test
    public void testMain() {
        logger.debug("BEGIN");
        String data = "lovelycomossez";

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

        int retVal = -1;
        LinkedHashMap<Character, String> retMap = new LinkedHashMap<Character, String>();
        char[] chStr = data.toCharArray();


        for (int i = 0; i < chStr.length; i++) {
            if (retMap.get(chStr[i]) != null) {
                retMap.put(chStr[i], retMap.get(chStr[i]) + "#" + String.valueOf(i));
            } else {
                retMap.put(chStr[i], String.valueOf(i));
            }
        }

        for (Map.Entry me : retMap.entrySet()) {
            String val = "" + me.getValue();
            if (!val.contains("#")) {
                retVal = Integer.valueOf(val);
                break;
            }
        }


        return retVal;

    }


}
