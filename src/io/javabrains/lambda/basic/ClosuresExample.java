package io.javabrains.lambda.basic;

public class ClosuresExample {

	public static void main(String[] args) {
		int i = 10;
		int b = 20;
		
		// a variavel b deve ser final, pois está sendo usada em uma expressao lambda - Closure. 
		// Mas o compilador infere que ela é final pois não mudou nenhuma vez ate ser executada no metodo
		doProcess(i, p -> System.out.println(i + b));
		doProcess(i+b, System.out::println);
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
}

interface Process {
	void process(int i);
}