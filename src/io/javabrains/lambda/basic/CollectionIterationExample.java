package io.javabrains.lambda.basic;

import java.util.Arrays;
import java.util.List;

import io.javabrains.lambda.basic.entity.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				); 
		
		System.out.println("Using for loop");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("\nUsing foreach loop");
		for (Person p : people) {
			System.out.println(p);
		}
		
		System.out.println("\nUsing foreach and method reference of java8");
		people.forEach(System.out::println);

		System.out.println("\nUsing lambda foreach in java8");
		people.forEach(p -> System.out.println(p));
		
		
		System.out.println("Using forecah and method reference and stream in java8");
		people.stream().forEach(System.out::println);
		
		System.out.println("Using forecah and method reference and stream and iterator in java8");
		people.stream().iterator().forEachRemaining(p -> {
			System.out.println(p.getFirstName() + " " + p.getLastName());
		});
		
	}
	
}
