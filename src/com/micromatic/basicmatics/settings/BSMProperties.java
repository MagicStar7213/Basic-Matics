package com.micromatic.basicmatics.settings;

import java.io.*;
import java.util.*;

/**Properties file loader*/
public class BSMProperties {
	/**References to the properties file*/
	public File file = new File(System.getProperty("user.home")+"/AppData/Local/Temp/bsm.properties");
	/**Allows to access the file*/
	public FileInputStream in;
	/**Allows to write the file*/
	public FileOutputStream out;
	/**Properties loading*/
	public Properties props = new Properties();
	
	/**
	 * Creates the file
	 * @throws IOException when it can't create the file
	 */
	public void create() throws IOException {
		file.createNewFile();
	}
	
	/**
	 * 
	 * @param key the key to check
	 * @return flase if the key doesn't exist and true if it exists
	 */
	public boolean existsKey(String key) {
		try {
			in = new FileInputStream(file);
			props.load(in);
			in.close();
			return props.containsKey(key);
		} catch (IOException io) { io.printStackTrace(); return false; }
	}
	
	/**
	 * It gets from the bsm.properties file if the results are aproximated or equal, by a boolean type
	 * @return aprox property
	 */
	public boolean getAprox() {
		try {
			in = new FileInputStream(file);
			props.load(in);
			in.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return Boolean.parseBoolean(props.getProperty("aprox"));
	}
	
	/**
	 * It sets the new property for aprox
	 * @param key the value of the key
	 */
	public void setAprox(String key)  {
		try {
			in = new FileInputStream(file);
			props.load(in);
			in.close();
			
			out = new FileOutputStream(file);
			if (props.containsKey("aprox")) {
				props.setProperty("aprox", key);
				props.store(out, null);
				out.close();
			}
			else {
				props.put("aprox", key);
				props.store(out, null);
				out.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	/**
	 * It gets the language to use for the application when it starts
	 * @return lang property
	 */
	public String getLang() {
		try {
			in = new FileInputStream(file);
			props.load(in);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return props.getProperty("lang");
	}
	
	/**
	 * It sets the language in the properties file
	 * @param key the language to use
	 */
	public void setLang(String key)  {
		try {
			in = new FileInputStream(file);
			props.load(in);
			in.close();
			
			out = new FileOutputStream(file);
			if (props.containsKey("lang")) {
				props.replace("lang", props.getProperty("lang"), key);
				props.store(out, null);
				out.close();
			}
			else {
				props.put("lang", key);
				props.store(out, null);
				out.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	/**
	 * Gets the Operating System on the properties file
	 * @return the os in the properties file
	 */
	public String getOs() {
		try {
			in = new FileInputStream(file);
			props.load(in);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return props.getProperty("os");
	}

	/**
	 * Sets the os image for use
	 * @param key the os name
	 */
	public void setOs(String key) {
		try {
			in = new FileInputStream(file);
			props.load(in);
			in.close();
			
			out = new FileOutputStream(file);
			if (props.containsKey("os")) {
				props.replace("os", props.getProperty("os"), key);
				props.store(out, null);
				out.close();
			}
			else {
				props.put("os", key);
				props.store(out, null);
				out.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}