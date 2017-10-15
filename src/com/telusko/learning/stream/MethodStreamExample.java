package com.telusko.learning.stream;

import java.util.Arrays;
import java.util.List;

public class MethodStreamExample {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Sem expressoes lambdas
//		Function<Integer, Integer> mapper = new Function<Integer, Integer>() {
//
//			@Override
//			public Integer apply(Integer i) {
//				return i * 2;
//			}
//		};
//		BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
//
//			@Override
//			public Integer apply(Integer i1, Integer i2) {
//				return i1 + i2;
//			}
//		};
//		Integer reduce = numbers.stream().map(mapper).reduce(0, accumulator);
		
		// Com expressao lambda
		Integer reduce = numbers.stream().map(n -> n * 2).reduce(0, Integer::sum);
		System.out.println(reduce);
		
	}
	
}
