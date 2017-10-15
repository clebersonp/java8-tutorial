package io.javabrains.lambda.basic;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value i is " + i);
			System.out.println(this); // this aponta para a instacia do objeto que chamou o metodo execute, ou seja ThisReferenceExample
		});
	}
	
	public static void main(String[] args) {
		
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
//		thisReferenceExample.doProcess(10, new Process() {
//			@Override
//			public void process(int i) {
//				System.out.println("Value of i is " + i);
//				System.out.println(this); // this aponta para o objeto anonino criado dentro da class
//			}
//			
//			@Override
//			public String toString() {
//				return "This is the anonymous inner class";
//			}
//		});
		
		
		thisReferenceExample.doProcess(10, i -> {
				System.out.println("Value i is " + i);
//				System.out.println(this); nao compila, pois o this é referencia de um objeto que está chamando
				// o metodo thisReferenceExample.doProcess(), porem é o metodo main static que está chamando,
				// e metodos staticos nao enxergam metodos de instancia
			});
		
		thisReferenceExample.execute();
	}
	
	@Override
	public String toString() {
		return "This is the ThisReferenceExample instance";
	}
}