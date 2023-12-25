package io.github.dwarfley.gradle.lwjglhelper;

import org.gradle.api.plugins.JavaPlugin;

public enum Configuration {
	
	IMPLEMENTATION(JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME),
	RUNTIME_ONLY(JavaPlugin.RUNTIME_ONLY_CONFIGURATION_NAME),
	TEST_IMPLEMENTATION(JavaPlugin.TEST_IMPLEMENTATION_CONFIGURATION_NAME),
	TEST_RUNTIME_ONLY(JavaPlugin.TEST_RUNTIME_ONLY_CONFIGURATION_NAME);
	
	private String mName;
	
	private Configuration(String pName){
		mName = pName;
	}
	
	String getName(){
		return mName;
	}
	
}
