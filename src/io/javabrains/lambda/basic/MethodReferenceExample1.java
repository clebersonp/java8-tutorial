package io.javabrains.lambda.basic;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		
		Thread t = new Thread(MethodReferenceExample1::printMessage); // MethodReferenceExcample1::printMessage === () -> printMessage()
		t.run();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}
	
}
