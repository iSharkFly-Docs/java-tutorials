package com.ossez.toolkits.codebank.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the test file for something like to quick run.
 * Once test finished, we need to move codes to different name, just like when we were student we like to eraser after using.
 *
 * @author YuCheng
 */
public class BlackboardTest {
    private final static Logger logger = LoggerFactory.getLogger(BlackboardTest.class);

    private static List<Integer> loopList = new ArrayList<>();

	/**
	 * Main Test to Run
	 */
	@Test
    public void testMain() {
        logger.debug("TREE TEST");
        String data = "{1,2,3,4,5,#,6,#,#,7,8,#,#}";

        this.subLogic(data);
    }


    /**
     * @param data
     */
    private void subLogic(String data) {
        logger.debug("Print Val - [{}]", data);
    }


}
