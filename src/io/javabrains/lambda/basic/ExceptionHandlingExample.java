package io.javabrains.lambda.basic;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		
		int [] numbers = {1, 2, 3, 4};
		int key = 1;

		// using a wrapper to catch exceptions
		BiConsumer<Integer, Integer> biConsumer = wrapperLambda((v, k) -> System.out.println(v / k));
		process(numbers, key, biConsumer);
		
		// handling Arithmetic Exception
//		process(numbers, key, (value, k) -> {
//			try {
//				System.out.println(value / key);
//			} catch (ArithmeticException e) {
//				System.out.println("An Arithmetic Exception happend!");
//			}
//		});
	}

//	private static void process(int[] numbers, int key) {
//		for (int number : numbers) {
//			System.out.println(number + key);
//		}
//	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		return (v, k) -> {
			try {
				System.out.println("Called by wrapperLambda method: ");
				biConsumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println("An Arithmetic Exception happend!\n");
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int number : numbers) {
			System.out.println("Called by process method");
			biConsumer.accept(number, key);
		}
	}
	
}
