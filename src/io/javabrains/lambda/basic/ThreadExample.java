package io.javabrains.lambda.basic;

public class ThreadExample {

	public static void main(String[] args) {
		
		System.out.println("First thread");
		
		for (int i = 0; i < 100; i++) {
			final int a = i;
			Thread thread = new Thread(() -> System.out.println(a + " Thread"));
			thread.run();
		}
		
	}
	
}
