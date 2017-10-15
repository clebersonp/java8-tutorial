package com.telusko.learning.consumer;

import java.util.ArrayList;
import java.util.List;

public class TimeOfOperationStreamExample {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		long inicioAddList = System.currentTimeMillis();
		for (int i = 0; i < 50_000_000; i++) {
			numbers.add(i);
		}
		
		double tempoAdicionarLista = (System.currentTimeMillis() - inicioAddList) / 1000d;
		System.out.println("Tempo para dicionar 50_000k numeros na lista em segundos: " + tempoAdicionarLista);
		
		
		
		long inicioLoop = System.currentTimeMillis();

		long a = 0;
		for (Integer i : numbers) {
			a += i;
		}
		
		double fimLoop = (System.currentTimeMillis() - inicioLoop) / 1000d;
		
		System.out.println("Tempo para ler 50_000k numeros usando o foreach em segundos: " + fimLoop);
		
		inicioLoop = System.currentTimeMillis();
		numbers.stream().forEach(i -> {
			int b = 0;
			b += i;
		});
		fimLoop = (System.currentTimeMillis() - inicioLoop) / 1000d;
		System.out.println("Tempo para ler 50_000k numeros usando foreach stream em segundos: " + fimLoop);

		inicioLoop = System.currentTimeMillis();
		numbers.parallelStream().forEach(i -> {
			int b = 0;
			b += i;
		});
		fimLoop = (System.currentTimeMillis() - inicioLoop) / 1000d;
		System.out.println("Tempo para ler 50_000k numeros usando foreach parallelStream em segundos: " + fimLoop);
		
		
		
	}
	
}
