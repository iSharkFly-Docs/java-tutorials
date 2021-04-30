package com.ossez.toolkits.codebank.tests.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * word-wrap Function
 * <ul>
 * <li>@see <a href= "https://www.ossez.com/t/a-word-wrap-functionality/13452">https://www.ossez.com/t/a-word-wrap-functionality/13452</a>
 * </li>
 * </ul>
 * </p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WordWrapTest {

    private final static Logger logger = LoggerFactory.getLogger(WordWrapTest.class);

    /**
     * Test word-wrap Function
     */
    @Test
    public void testMain() {
        logger.debug("BEGIN");


        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};
        int lineLength1_1 = 13;
        int lineLength1_2 = 20;

        int lineLength = lineLength1_1;

        List<String> returnList = new ArrayList<>();

        String dataStr = "";
        for (String arrayData : words1) {
            dataStr = dataStr + arrayData + "-";
        }


        while (StringUtils.isNotEmpty(dataStr)) {
            if (StringUtils.length(dataStr) <= lineLength) {
                returnList.add(dataStr);
                break;
            }

            String subStr = dataStr.substring(0, lineLength);
            if (subStr.endsWith("-")) {
                subStr = StringUtils.removeEnd(subStr, "-");
            } else {
                if (StringUtils.equals(dataStr.substring(lineLength, lineLength + 1), "-")) {
                    subStr = StringUtils.substring(subStr, 0, lineLength);
                } else {
                    subStr = StringUtils.substring(subStr, 0, StringUtils.lastIndexOf(subStr, "-"));
                }
            }
            returnList.add(subStr);


            dataStr = StringUtils.replace(dataStr, subStr, "");
            dataStr = StringUtils.removeStart(dataStr, "-");
            dataStr = StringUtils.removeEnd(dataStr, "-");
        }

        logger.debug("{}", returnList);
    }


}

