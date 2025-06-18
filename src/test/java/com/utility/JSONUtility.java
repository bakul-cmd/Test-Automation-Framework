package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(Env env) {
	    Gson gson = new Gson();
	    File jsonFile = new File(System.getProperty("user.dir") + "/config/config.json"); // Use '/' for cross-platform compatibility
	    FileReader fileReader = null;
	    try {
	        fileReader = new FileReader(jsonFile);
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException("Configuration file not found at: " + jsonFile.getAbsolutePath(), e); // Replace with meaningful error handling
	    }
	    Config config = gson.fromJson(fileReader, Config.class);
	    if (config == null || config.getEnvironments() == null) {
	        throw new RuntimeException("Invalid configuration data in file: " + jsonFile.getAbsolutePath());
	    }
	    Environment environment = config.getEnvironments().get(env.name());
	    if (environment == null) {
	        throw new RuntimeException("Environment " + env.name() + " not found in configuration file.");
	    }
	    return environment;
	}

}

