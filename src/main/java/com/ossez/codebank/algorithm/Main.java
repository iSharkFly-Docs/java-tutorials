package com.ossez.codebank.algorithm;

import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static Options options = new Options();
	private static Properties properties = new Properties();

	private static CommandLine cl = null;

	private static boolean dryRun = false;
	private static int limit = 0;
	private static boolean force = false;

	public static void main(String[] args) {

		// get the idx feed properties file
		Main.parseProperties();

		// load console options
		Main.parseCommandLine(args);

		logger.debug("Starting feeds...");
		System.out.println("starting feeds...");

		// execute the feeds
		Main.executeFeeds();

	}

	/**
	 * Executes the feeds specified in the feeds.properties file.
	 */
	private static void executeFeeds() {

	}

	/**
	 * Parses the properties file to get a list of all feeds.
	 */
	private static void parseProperties() {
		try {
			// load the properties file
			logger.debug("Parsing properties");
			Main.properties.load(Main.class.getClassLoader().getResourceAsStream("rets.properties"));

			// load the feeds

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Could not parse feed properties", ex);
		}
	}

	/**
	 * Handles creation of console options.
	 */
	private static void parseCommandLine(String[] args) {

		// parse command line options
		CommandLineParser parser = new GnuParser();

		try {
			Main.cl = parser.parse(Main.options, args);

			// get the dry run option
			Main.dryRun = Main.cl.hasOption("d");
			logger.trace("Value of dryRun: " + dryRun);

			// get the limit option
			// Main.limit = Utility.parseInt(Main.cl.getOptionValue("l", "0"));
			logger.trace("Value of limit: " + Main.limit);

			// get the force option
			Main.force = Main.cl.hasOption("u");
			logger.trace("Value of force: " + Main.force);
		} catch (Exception ex) {
			logger.error("An error ocurred parsing command line arguments", ex);
		}
	}
}
