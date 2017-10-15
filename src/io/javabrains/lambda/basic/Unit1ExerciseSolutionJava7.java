package io.javabrains.lambda.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.javabrains.lambda.basic.entity.Person;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				); 
		
		// Step1: Sort list by last name
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				return person1.getLastName().compareToIgnoreCase(person2.getLastName());
			}
		});
		
		// Step2: Create a method that prints all elements in the list
		System.out.println("Print all people");
		printAll(people);
		
		// Step3: Create a method that prints all people that have last name beginning with C
		System.out.println("Printing all person with last name beginning with C");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}

interface Condition {
	boolean test(Person p);
}
