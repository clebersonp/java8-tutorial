package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123


        // method reference

        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123


        Something something = new Something();

        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // constructor reference

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
        
        // --------- com classe anonima
        PersonFactory<Person> personFactory2 = new PersonFactory<Person>() {
			@Override
			public Person create(String firstName, String lastName) {
				return new Person(firstName, lastName);
			}
        };
        
        Person cleberson = personFactory2.create("cleberson", "pauluci");
        System.out.println(cleberson);
        // ------- com classe anonima
        
        
        // ------- com expressao lambda
        PersonFactory<Person> personFactory3 = (String firstName, String lastName) -> new Person(firstName, lastName);
        
        Person bruna = personFactory3.create("bruna", "paola");
        System.out.println(bruna);
        // ------- com expressao lambda
        
        PersonFactory<Person> personFactory4 = (firstName, lastName) -> new Person(firstName, lastName);
        
        Person mike = personFactory4.create("mike", "two");
        System.out.println(mike);
    }
}
