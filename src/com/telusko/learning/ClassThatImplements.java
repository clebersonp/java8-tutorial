package com.telusko.learning;

public class ClassThatImplements implements InterfaceI, InterfaceJ {

	// preciso sobrescrever o metodo show default das duas interfaces
	// pois é ambiguo.
	
	@Override
	public void show() {
//		InterfaceJ.super.show();
		System.out.println("Execute the method show() of ClassThatImplements");
	}

}
