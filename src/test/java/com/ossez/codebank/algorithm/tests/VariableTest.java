package com.ossez.codebank.algorithm.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Object of VariableOssez
 *
 * @author YuCheng
 */
class OssezVariable {
    int s1, s2;
    static int s3;

    OssezVariable(int x, int y, int z) {
        s1 = x;
        s2 = y;
        s3 = z;
    }
}

/**
 * @author YuCheng
 */
public class VariableTest extends TestCase {

    private final static Logger logger = LoggerFactory.getLogger(VariableTest.class);

    /**
     * Do RetsServerConnection Test
     */
    @Test
    public void testStaticVariableChange() {

//		OssezVariable objA = new OssezVariable(1, 2, 3);
//		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objA.s1, objA.s2, OssezVariable.s3);
//
//		OssezVariable objB = new OssezVariable(4, 5, 6);
//		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objA.s1, objA.s2, OssezVariable.s3);
//		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objB.s1, objB.s2, OssezVariable.s3);

        String[][] connections = {{"192.167.0.0", "192.167.0.1"}, {"192.167.0.2", "192.167.0.0"}, {"192.167.0.0", "192.167.0.3"}};
        Boolean[][] connectionsP = {{false, false}, {false, false}, {false, false}};
        String[] toggleIps = {"192.167.0.1", "192.167.0.0", "192.167.0.2", "192.167.0.0", "0.0.0.0"};
        HashMap<String, String> ipMap = new HashMap();
        HashMap<String, Boolean> devMap = new HashMap();
        Integer retArray[] = new Integer[toggleIps.length];


        for (int i = 0; i < toggleIps.length; i++) {
            String toggleIp = toggleIps[i];
            int count = 0;

            // INIT
            Boolean dStatus = false;
            for (int row = 0; row < connections.length; row++) {
                for (int col = 0; col < connections[row].length; col++) {

                    String ipKey = connections[row][col];
                    if (ipKey.equals(toggleIp))
                        if (connectionsP[row][col] == false) {
                            connectionsP[row][col] = true;
                            dStatus = true;
                        }
                        else if (connectionsP[row][col] == true) {
                            connectionsP[row][col] = false;
                            dStatus = false;
                        }
                }
            }

            String retStr = "";
            for (int row = 0; row < connectionsP.length; row++) {
                List<Boolean> statusList = new ArrayList<>();
                for (int col = 0; col < connectionsP[row].length; col++) {
                    statusList.add(connectionsP[row][col]);
                }

                if (statusList.get(0) &&  statusList.get(1) && dStatus) {
                    count ++;
                }
            }

            System.out.println(count);


        }


//
    }

}
