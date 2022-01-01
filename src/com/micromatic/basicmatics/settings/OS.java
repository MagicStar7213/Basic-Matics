package com.micromatic.basicmatics.settings;

/**OS variables and methods*/
public interface OS {
	/**
	 * Gets the name of the OS
	 */
	String name = System.getProperty("os.name").toLowerCase();
}