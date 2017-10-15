package com.telusko.learning;

public interface InterfaceI {

	default void show() {
		System.out.println("Execute the method show() of InterfaceI");
	}
	
	// um metodo default da interface não pode sobrescrever um metodo de um objeto pai
//	default boolean equals(Object o) {
//		return true;
//	}
	
	public static void init() {
		InterfaceJ.init();
		System.out.println("Method init() from InterfaceI call in the static way");
	}
	
}
