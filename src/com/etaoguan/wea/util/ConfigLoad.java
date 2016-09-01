package com.etaoguan.wea.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoad {
	private static String CONFIG_FILENAME = "/server.properties";
	private Properties prop = null;

	public ConfigLoad() {
		loadProperties();
	}

	public static void main(String[] args) {
		System.out.println(new ConfigLoad().getProp().getProperty("Url"));
	}
	
	

	public Properties getProp() {
		return prop;
	}

	private void loadProperties() {
		try {
			// Open the props file

			InputStream is = ConfigLoad.class
					.getResourceAsStream(CONFIG_FILENAME);

			if (is == null) {
				System.err.println("CONFIG_FILENAME inputStream is null");
			}

			prop = new Properties();
			// Read in the stored properties
			prop.load(is);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			prop = null;
		}
	}

}
