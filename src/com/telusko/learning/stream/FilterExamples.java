package com.telusko.learning.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterExamples {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(12, 20, 35, 46, 55, 68, 75);
		
		Predicate<Integer> predicate = i -> i % 5 == 0;
		
//		Integer reduce = numbers.stream()
//								.filter(predicate)
//								.map(i -> i * 2)
//								.reduce(0, Integer::sum);

		Integer reduce = numbers.stream()
								.filter(predicate)
								.map(i -> i * 2)
								.findFirst().orElse(0);
		
		System.out.println(reduce);
		
	}
	
}
