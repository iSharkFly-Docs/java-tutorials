package com.ossez.toolkits.codebank.tests.interview;

import com.ossez.toolkits.codebank.common.model.request.TopicRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * This is the test file for something like to quick run.a Diophantine equation is a polynomial equation
 * Once test finished, we need to move codes to different name, just like when we were student we like to eraser after using.
 *
 * @author YuCheng
 */
public class BlackboardTest {
    private final static Logger logger = LoggerFactory.getLogger(BlackboardTest.class);

    private static List<Integer> loopList = new ArrayList<>();

    @Test
    public void test2st() {


    }

    @Test
    public void test1st() {

        Hashtable<String, String> hashTable = new Hashtable<>();

        String data = "aass";
        char[] strArray = data.toCharArray();
        String retStr = "";
//        char xC = Character.toString("C");
//        CharUtils.toChar()

        if (data.length() == 1) {
            retStr = data;
        }

        for (int i = 0; i < strArray.length; i++) {
            String valStr = Character.toString(strArray[i]);
            String rData = data;
            rData = data.replace(valStr, "");
            rData = rData.replace(valStr.toUpperCase(Locale.ROOT), "");
            rData = rData.replace(valStr.toLowerCase(Locale.ROOT), "");

            if (rData.length() == 0) {
                retStr = "";
            } else if (rData.length() + 1 == data.length()) {
                retStr = valStr;
                break;
            }

//            char val1 = strArray[i];
//            for(int j=i; j <strArray.length; j++) {
//                if (val1 == strArray[i]) {
//                    break;
//                }
//            }
//
//            c =val1;
        }

        System.out.println(retStr);

    }

    /**
     * Main Test to Run
     */
    @Test
    public void testMain() {
        logger.debug("TREE TEST");

        TopicRequest topicRequest = new TopicRequest();
//		topicRequest.setTopic_id(11);
        logger.debug("HashCode 1 - {}", topicRequest.hashCode());

        logger.debug("HashCode AaAaAa - {}", "AaAaAa".hashCode());
        logger.debug("HashCode BBAaBB - {}", "BBAaBB".hashCode());

//        if((1/2) && false) {
//
//        }

//		topicRequest = new TopicRequest();
        logger.debug("HashCode 2 - {}", topicRequest.hashCode());

        String data = "{1,2,3,4,5,#,6,#,#,7,8,#,#}";
        String[] dataArray = new String[3];
        this.subLogic(data);
//        StringUtils.replace();
        String s = "Well-";
        System.out.println(s.replace(s, ""));
        s = s.replace(s, "");

        //        int lineLength1_1 = 20;
//        int lineLength1_2 = 20;
        
        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};

        int lineLength = 20;

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


        System.out.println(returnList);


    }



    /**
     * @param data
     */
    private void subLogic(String data) {
        logger.debug("Print Val - [{}]", data);
    }


}
