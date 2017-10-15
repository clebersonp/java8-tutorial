package io.javabrains.lambda.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.lambda.basic.entity.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		System.out.println("Print all people");
		
		// o compilador vai olhar a parametro do cosumer e passar a instancia de Person para o metodo println(p);
		performConditionally(people, p -> true, System.out::println); // System.out::println ==== p -> System.out.println(p);

	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consume) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consume.accept(person);
			}
		}
	}
}
