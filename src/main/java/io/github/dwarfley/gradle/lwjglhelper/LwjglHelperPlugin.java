package io.github.dwarfley.gradle.lwjglhelper;

import org.gradle.api.*;
import org.gradle.internal.os.OperatingSystem;

public class LwjglHelperPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project pProject){
		
	}
	
	private String getPlatform(){
		
		OperatingSystem lOs = OperatingSystem.current();
		String lOsArch = System.getProperty("os.arch");
		
		if(lOs == OperatingSystem.LINUX){
			return getLinuxPlatform(lOsArch);
		}else if(lOs == OperatingSystem.MAC_OS){
			return getMacOsPlatform(lOsArch);
		}else if(lOs == OperatingSystem.WINDOWS){
			return getWindowsPlatform(lOsArch);
		}else{
			return null;
		}
		
	}
	
	private String getLinuxPlatform(String pOsArch){
		
		String lResult = "natives-linux";
		
		if(pOsArch.startsWith("arm") || pOsArch.startsWith("aarch64")){
			if(pOsArch.contains("64") || pOsArch.startsWith("armv8")){
				lResult += "-arm64";
			}else{
				lResult += "-arm32";
			}
		}else if(pOsArch.startsWith("ppc")){
			lResult += "-ppc64le";
		}else if(pOsArch.startsWith("riscv")){
			lResult += "-riscv64";
		}
		
		return lResult;
	}
	
	private String getMacOsPlatform(String pOsArch){
		
		String lResult = "natives-macos";
		
		if(pOsArch.startsWith("aarch64")){
			lResult += "-arm64";
		}
		
		return lResult;
	}
	
	private String getWindowsPlatform(String pOsArch){
		
		String lResult = "natives-windows";
		
		if(pOsArch.startsWith("aarch64")){
			lResult += "-arm64";
		}else if(!pOsArch.contains("64")){
			lResult += "-x86";
		}
		
		return lResult;
	}
	
}
