package com.ossez.toolkits.codebank;

import java.util.Properties;
import java.util.concurrent.ExecutorService;

import com.google.gdata.data.docs.Size;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Test Class
 *
 * @author YuCheng Hu
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static Options options = new Options();
    private static Properties properties = new Properties();

    private static CommandLine cl = null;

    private static boolean dryRun = false;
    private static int limit = 0;
    private static boolean force = false;


    public static void main(String[] args) {

        SizeCount sizeCount = new SizeCount();

        sizeCount.setCustomer(70);
        sizeCount.setTeller(3);
        sizeCount.setQueueSize(3);

        SizeCount exeSizeCount = algorithmBanker(sizeCount);
        logger.debug("time Require ->>> {}", exeSizeCount.getTimeRequire());

        if (exeSizeCount.getCustomer() > 0) {
            exeSizeCount = exeSizeCount = callOtherBank(exeSizeCount);
            logger.debug("time Require - {}", exeSizeCount.getTimeRequire());
        }

        // Current Size:
        logger.debug("Spending Time: [{}]", exeSizeCount.getTimeRequire());

        /**
         * After this time, all process will done and we can re-check again.
         *  if we set sizeCount.setCustomer(70);
         *  After this value check function.
         *  we still have 64 customer need to get processed.
         *  In this case, we need may call callOtherBank more than once. to reach the value banker manager wanted.
         */

        /**
         * How many Teller need for C.
         * We need to set up time frame first.
         *
         * For current, will sizeCount.getCustomer - sizeCount.getQueueSize.
         * Because, we don't want getCustomer waite.
         */

        /**
         * About send tellter to home.
         *
         * There are three conditions:
         * 1. Size of Customer == 0;
         * 2. Size of Queue == 0;
         * 3. No active Thread is running, or active thread < size of teller.
         */

        /**
         * About how many teller.
         * Time is matter, different tiller can process different business.
         * We need to have average time for each business process may coast. in this case I was set time all == 1000ms (not in real world).
         * And the Size of Queue too.
         *
         * Check the algorithmBanker function bellow.
         *
         * Run this function, if sizeCount.getCustomer > 0. All init teller should in.
         * and we need to get extra teller for size sizeCount.getCustomer()
         *
         * if sizeCount.getCustomer < sizeCount.getQueueSize + sizeCount.getTeller(), we can send some teller to home.
         *
         * Check this every  exeSizeCount.getTimeRequire(), make sure  exeSizeCount.getTimeRequire() == 0 then do tellter call.
         */

    }


    public static SizeCount algorithmBanker(SizeCount sizeCount) {

        if (sizeCount.getCustomer() <= sizeCount.getTeller()) {
            Integer exeCount = sizeCount.getCustomer();
            for (int i = 0; i < exeCount; i++) {
                TellerThread R1 = new TellerThread("TellerThread-1", 1000);
                R1.start();
                sizeCount.setTimeRequire(sizeCount.getTimeRequire() + 1000);
            }
            sizeCount.setCustomer(0);

        } else {
            logger.debug("working / sleep teller - {}/{}", sizeCount.getTeller(), 0);
            Integer exeCount = sizeCount.getCustomer();
            for (int i = 0; i < sizeCount.getTeller(); i++) {
                TellerThread R1 = new TellerThread("TellerThread-1", 1000);
                R1.start();
                sizeCount.setCustomer(sizeCount.getCustomer() - 1);
                sizeCount.setTimeRequire(sizeCount.getTimeRequire() + 1000);
            }

            // Q
            if ((exeCount - sizeCount.getTeller()) > sizeCount.getQueueSize()) {
                for (int i = 0; i < sizeCount.getQueueSize(); i++) {
                    TellerThread R1 = new TellerThread("TellerThread-1", 1000);
                    R1.start();
                    sizeCount.setCustomer(sizeCount.getCustomer() - 1);
                    sizeCount.setTimeRequire(sizeCount.getTimeRequire() + 1000);
                }
            } else {
                for (int i = 0; i < exeCount - sizeCount.getTeller(); i++) {
                    TellerThread R1 = new TellerThread("TellerThread-1", 1000);
                    R1.start();
                    sizeCount.setCustomer(sizeCount.getCustomer() - 1);
                    sizeCount.setTimeRequire(sizeCount.getTimeRequire() + 1000);
                }
            }


        }

        return sizeCount;
    }

    private static SizeCount callOtherBank(SizeCount sizeCount) {
        TellerThread R1 = new TellerThread("TellerThread-1", 1000);
        R1.start();
        sizeCount.setCustomer(sizeCount.getCustomer() - 1);
        sizeCount.setTimeRequire(sizeCount.getTimeRequire() + 1000);

        return sizeCount;
    }


}
