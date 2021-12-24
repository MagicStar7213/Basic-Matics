package com.micromatic.basicmatics.settings;

public interface OS {
	String name = System.getProperty("os.name").toLowerCase();
}