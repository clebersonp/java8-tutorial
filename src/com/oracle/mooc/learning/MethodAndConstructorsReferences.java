package com.oracle.mooc.learning;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodAndConstructorsReferences {

	public static void main(String[] args) {
		
		String myName = "Cleberson";
		Integer myAge = 30;
		MethodAndConstructorsReferences macr = new MethodAndConstructorsReferences();
		
		// metodo de referencia static
		macr.consumidor(MethodAndConstructorsReferences::imprimir, myName);
		
		// metodo de referencia usando objeto de referencia 
		int myDoubleAge = macr.functionDobrar(macr::dobrarValor, myAge );
		System.out.println(myDoubleAge);
		
		String myNickName = macr.functionSubstring(myName::substring, 0, 3);
		System.out.println(myNickName);
		
	}
	
	public static void imprimir(String value) {
		System.out.println(value);
	}
	
	public void consumidor(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}
	
	public int functionDobrar(Function<Integer, Integer> function, Integer value) {
		return function.apply(value);
	}
	
	public int dobrarValor(int value) {
		return value * 2;
	}
	
	public String functionSubstring(BiFunction<Integer, Integer, String> function, Integer init, Integer end) {
		return function.apply(init, end);
	}
	
}
