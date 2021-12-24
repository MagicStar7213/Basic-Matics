package com.micromatic.basicmatics.settings;

import java.io.*;
import java.util.*;

public class BSMProperties {
	public File file = new File(System.getProperty("user.home")+"/AppData/Local/Temp/bsm.properties");
	public FileInputStream in;
	public FileOutputStream out;
	public Properties props = new Properties();
	
	/**
	 * Creates the file
	 * @throws IOException
	 */
	public void create() throws IOException {
		file.createNewFile();
	}
	
	/**
	 * 
	 * @param key
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
	 * @param key
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
	 * @param key
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
	
	public String getOs() {
		try {
			in = new FileInputStream(file);
			props.load(in);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return props.getProperty("os");
	}
	
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