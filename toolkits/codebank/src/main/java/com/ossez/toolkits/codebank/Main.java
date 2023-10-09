package com.ossez.toolkits.codebank;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

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


    }
}
