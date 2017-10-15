package com.telusko.learning.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// essa forma cria uma classe anonima
		
//		Consumer<Integer> consumer = new Consumer<Integer>() {
//			@Override
//			public void accept(Integer i) {
//				System.out.println(i);
//			}
//		};
		
		// usando expressao lambda nao cria classe anonimas adicionais, e sim funções
		// (Integer i) é o parametro do metodo accept e depois -> {bloco de codigo} é a definicao do metodo
		Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
		
		numbers.forEach(consumer);
	}
	
}
