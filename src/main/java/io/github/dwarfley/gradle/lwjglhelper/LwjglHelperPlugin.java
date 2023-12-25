package io.github.dwarfley.gradle.lwjglhelper;

import org.gradle.api.*;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.plugins.*;

import io.github.dwarfley.gradle.lwjglhelper.util.*;

public class LwjglHelperPlugin implements Plugin<Project> {
	
	private static final String mVersion = "3.3.3";
	
	private String mPlatform;
	private DependencyHandler mDepHandler;
	
	@Override
	public void apply(Project pProject){
		
		mPlatform = PlatformUtil.getPlatform();
		mDepHandler = pProject.getDependencies();
		
		addPlatform("org.lwjgl:lwjgl-bom:" + mVersion);
		addDependency("org.lwjgl:lwjgl", true);
		
		ExtensionContainer lExtContainer = mDepHandler.getExtensions();
		ExtraPropertiesExtension lExt = lExtContainer.getExtraProperties();
		
		lExt.set("lwjgl", new VoidClosure<>((String pName) -> {
			
			LwjglDependency lDependency = LwjglDependency.find(pName.toLowerCase());
			
			if(lDependency != null){
				addDependency("org.lwjgl:lwjgl-" + lDependency.getName(), lDependency.hasNatives(mPlatform));
			}else{
				throw new GradleException("Unknown lwjgl dependency '" + pName + "'!");
			}
			
		}));
		
	}
	
	private void addDependency(String pName, boolean pNative){
		
		addDependency(Configuration.IMPLEMENTATION, pName);
		
		if(pNative){
			addDependency(Configuration.RUNTIME_ONLY, pName + "::" + mPlatform);
		}
		
	}
	
	private void addPlatform(String pName){
		addDependency(Configuration.IMPLEMENTATION, mDepHandler.platform(pName));
	}
	
	private void addDependency(Configuration pConfiguration, String pName){
		addDependency(pConfiguration, mDepHandler.create(pName));
	}
	
	private void addDependency(Configuration pConfiguration, Dependency pDependency){
		mDepHandler.add(pConfiguration.getName(), pDependency);
	}
	
}
