package com.bms.adventure.utils;

import java.util.Properties;
import java.io.*;

/**
 * The PropertyLoader class reads in the properties necessary for
 * the adventure projects details.
 * @author Gabriel Zingle
 */
public class PropertyLoader {
	
	private static Properties props;
	
	// Temporary method used for testing
	public static void main(String[] args) {
		
	}
	
	public static Properties getProperties() {
		if (props ==  null) {
			try {
				InputStream input = ClassLoader.getSystemResourceAsStream("adventure.properties");
				props = new Properties();
				props.load(input);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return props;
	}

}
