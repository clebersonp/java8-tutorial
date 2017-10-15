package io.javabrains.lambda.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.lambda.basic.entity.Person;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				); 
		
		// Step1: Sort list by last name
		people.sort((p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
		
		// Step2: Create a method that prints all elements in the list
		System.out.println("Print all people");
		performConditionally(people, p -> true, p -> System.out.println(p));
		
		// Step3: Create a method that prints all people that have last name beginning with C
		System.out.println("\nPrinting all person with last name beginning with C");
		performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consume) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consume.accept(person);
			}
		}
	}
}