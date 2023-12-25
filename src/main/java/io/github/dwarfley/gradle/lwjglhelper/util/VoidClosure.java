package io.github.dwarfley.gradle.lwjglhelper.util;

import java.util.function.Consumer;

import org.gradle.api.GradleException;

import groovy.lang.Closure;

public class VoidClosure<T> extends Closure<Void> {
	
	private static final long serialVersionUID = -5189749209685352128L;
	
	private Consumer<T> mConsumer;
	
	public VoidClosure(Consumer<T> pConsumer){
		super(pConsumer);
		mConsumer = pConsumer;
	}
	
	@SuppressWarnings("unchecked")
	public Object doCall(Object pObject){
		try{
			mConsumer.accept((T) pObject);
		}catch(ClassCastException lEx){
			throw new GradleException("Invalid arguments for lwjgl closure!");
		}
		return null;
	}
	
}
