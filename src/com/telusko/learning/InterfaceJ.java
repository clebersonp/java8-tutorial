package com.telusko.learning;

public interface InterfaceJ {

	default void show() {
		System.out.println("Execute the method show() of InterfaceJ");
	}
	
	public static void init() {
		System.out.println("Method init() from InterfaceJ call in the static way");
	}
}
