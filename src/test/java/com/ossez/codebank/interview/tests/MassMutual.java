package com.ossez.codebank.interview.tests;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * MassMutual
 * 
 * @author Yucheng
 *
 */
public class MassMutual {

	private final static Logger logger = LoggerFactory.getLogger(MassMutual.class);

	@Test
	public void loadOBJ() {
		logger.debug("Test JSON LOAD TO OBJ");
		List<WoodChuck> woodChuckList = new ArrayList<WoodChuck>();
		List<File> dataFileList = new ArrayList<File>();

		try {
			dataFileList = (List<File>) FileUtils.listFiles(new File("C:\\Users\\Yucheng\\Documents\\Data-Sample\\massmutual"),
					TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

			for (File file : dataFileList) {

				woodChuckList.add(processWoodChuck(FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
			}

			for (WoodChuck woodChuck : woodChuckList) {
				logger.debug("\r\n");
				logger.debug("name - [{}]", woodChuck.getName());
				logger.debug("aliases0 - [{}]", woodChuck.getAliases0());
				logger.debug("aliases1 - [{}]", woodChuck.getAliases1());
				logger.debug("height - [{}]", woodChuck.getHeight());
				logger.debug("weight - [{}]", woodChuck.getWeight());
				logger.debug("woodChuckedWeight - [{}]", woodChuck.getWoodChuckedWeight());
			}

		}

		catch (Exception e) {
			// TODO: handle exception
			logger.error("API Data Table Process Error {}", e);
		}

	}

	/**
	 * 
	 * @param jData
	 * @return
	 */
	private WoodChuck processWoodChuck(String jData) {
		WoodChuck woodChuck = new WoodChuck();

		JsonElement jsonElement = new JsonParser().parse(jData);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		if (jsonObject.get("aliases") != null && jsonObject.get("aliases").isJsonArray()) {

			// name
			woodChuck.setName(jsonObject.get("name").getAsString());

			// aliases
			JsonArray aliases = jsonObject.getAsJsonArray("aliases");
			woodChuck.setAliases0(aliases.get(0).getAsString());
			woodChuck.setAliases1(aliases.get(1).getAsString());

			// physical
			woodChuck.setHeight(jsonObject.get("physical").getAsJsonObject().get("height_in").getAsString());
			woodChuck.setWeight(jsonObject.get("physical").getAsJsonObject().get("weight_lb").getAsString());

			// woodChuckedWeight
			woodChuck.setWoodChuckedWeight(jsonObject.get("wood_chucked_lbs").getAsString());

		} else {
			// name
			woodChuck.setName(jsonObject.get("name").getAsString());

			// aliases
			woodChuck.setAliases0(jsonObject.get("aliases.0").getAsString());
			woodChuck.setAliases1(jsonObject.get("aliases.1").getAsString());

			// physical
			woodChuck.setHeight(jsonObject.get("physical.height_in").getAsString());
			woodChuck.setWeight(jsonObject.get("physical.weight_lb").getAsString());

			// woodChuckedWeight
			woodChuck.setWoodChuckedWeight(jsonObject.get("wood_chucked_lbs").getAsString());
		}

		return woodChuck;

	}

	/*
	 * + WoodChuck OBJ for JSON process. +
	 */
	class WoodChuck {
		private String name = null;
		private String aliases0 = null;
		private String aliases1 = null;
		private String height = null;
		private String weight = null;
		private String woodChuckedWeight = null;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAliases0() {
			return aliases0;
		}

		public void setAliases0(String aliases0) {
			this.aliases0 = aliases0;
		}

		public String getAliases1() {
			return aliases1;
		}

		public void setAliases1(String aliases1) {
			this.aliases1 = aliases1;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getWoodChuckedWeight() {
			return woodChuckedWeight;
		}

		public void setWoodChuckedWeight(String woodChuckedWeight) {
			this.woodChuckedWeight = woodChuckedWeight;
		}

	}

}
