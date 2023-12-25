package io.github.dwarfley.gradle.lwjglhelper;

import java.util.*;

public enum LwjglDependency {
	
	ASSIMP("assimp"),
	BGFX("bgfx"),
	CUDA("cuda", false),
	EGL("egl", false),
	FMOD("fmod", false),
	FREETYPE("freetype"),
	GLFW("glfw"),
	HARFBUZZ("harfbuzz"),
	HWLOC("hwloc"),
	JAWT("jawt", false),
	JEMALLOC("jemalloc"),
	KTX("ktx"),
	LIBDIVIDE("libdivide"),
	LLVM("llvm"),
	LMDB("lmdb"),
	LZ4("lz4"),
	MEOW("meow"),
	MESHOPTIMIZER("meshoptimizer"),
	NANOVG("nanovg"),
	NFD("nfd"),
	NUKLEAR("nuklear"),
	ODBC("odbc", false),
	OPENAL("openal"),
	OPENCL("opencl", false),
	OPENGL("opengl"),
	OPENGLES("opengles"),
	OPENVR("openvr"),
	OPENXR("openxr"),
	OPUS("opus"),
	OVR("ovr"),
	PAR("par"),
	REMOTERY("remotery"),
	RPMALLOC("rpmalloc"),
	SHADERC("shaderc"),
	SPVC("spvc"),
	SSE("sse"),
	STB("stb"),
	TINYEXR("tinyexr"),
	TINYFD("tinyfd"),
	TOOTLE("tootle"),
	VMA("vma"),
	VULKAN("vulkan", false, List.of("natives-macos", "natives-macos-arm64")),
	XXHASH("xxhash"),
	YOGA("yoga"),
	ZSTD("zstd");
	
	private String mName;
	private boolean mHasNatives;
	private List<String> mExceptions;
	
	private LwjglDependency(String pName){
		this(pName, true);
	}
	
	private LwjglDependency(String pName, boolean pHasNatives){
		this(pName, pHasNatives, new ArrayList<>());
	}
	
	private LwjglDependency(String pName, boolean pHasNatives, List<String> pExceptions){
		mName = pName;
		mHasNatives = pHasNatives;
		mExceptions = pExceptions;
	}
	
	String getName(){
		return mName;
	}
	
	boolean hasNatives(String pPlatform){
		return mExceptions.contains(pPlatform) ? !mHasNatives : mHasNatives;
	}
	
	static LwjglDependency find(String pName){
		
		for(LwjglDependency lDependency : LwjglDependency.values()){
			if(lDependency.getName().equals(pName)){
				return lDependency;
			}
		}
		
		return null;
	}
	
}
