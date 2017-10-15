package com.telusko.learning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Runnable {
	
	private Long number;
	private List<Long> numbers;
	
	public MyThread(List<Long> numbers, Long number) {
		this.numbers = numbers;
		this.number = number;
	}
	
	@Override
	public void run() {
		synchronized(this) {
			numbers.add(number);
		}
	}
	
	public void setNumber(Long number) {
		synchronized (this) {
			this.number = number;
		}
	}

	public static void main(String[] args) {
		
		CopyOnWriteArrayList<Long> syncList = new CopyOnWriteArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(8);
		MyThread task = new MyThread(syncList, 0L);
		
		long inicioAddList = System.currentTimeMillis();
		for (long i = 0; i < 20_000_000; i++) {
			task.setNumber(i);
			executor.submit(task);
		}
		
		System.out.println("Tamanho da lista com threads: " + syncList.size());
		
		double fimAddList = (System.currentTimeMillis() - inicioAddList) / 1000D;
		executor.shutdown();
		
		System.out.println("Tempo para adicionar 20_000k de numeros a lista em segundos: " + fimAddList);
		
		inicioAddList = System.currentTimeMillis();
		List<Long> list = new ArrayList<>();
		for (long i = 0; i < 20_000_000; i++) {
			list.add(i);
		}
		System.out.println("Tamanho da lista sem threads: " + list.size());
		fimAddList = (System.currentTimeMillis() - inicioAddList) / 1000D;
		
		System.out.println("Tempo para adicionar 20_000k de numeros sem threads a lista em segundos: " + fimAddList);
		System.exit(0);
	}
	
}
