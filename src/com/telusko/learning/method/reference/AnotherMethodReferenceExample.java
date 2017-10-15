package com.telusko.learning.method.reference;

public class AnotherMethodReferenceExample {

	public static void main(String[] args) {
		
		MyAnotherClass mc = new MyAnotherClass();
		int i = 100;
		
		// esse metodo por referencia compila pois tem a mesma assinatura do metodo calc da interface CalcNumber
		// ou seja, espera um int de entrada no parametro e retorna um int, pois isso pode ser utilizado
		// como metodo de referencia
		mc.print(i, AdditionalNumber::addValue); // Compila
		
//		mc.print(i, n -> AdditionalNumber.addValue(n)); // Compila
		
//		mc.print(i, (n) -> AdditionalNumber.addValue(n)); // Compila
		
//		mc.print(i, (int n) -> AdditionalNumber.addValue(n)); // Compila
		
//		mc.print(i, (int n) -> { return AdditionalNumber.addValue(n); }); // Compila
		
//		mc.print(i, new CalcNumber() { // Compila
//			@Override
//			public int calc(int i) {
//				return AdditionalNumber.addValue(i);
//			}
//		});
	}
}

class MyAnotherClass {
	public void print(int i, CalcNumber c) {
		i = c.calc(i);
		System.out.println(i);
	}
}

interface CalcNumber {
	int calc(int i);
}

class AdditionalNumber {
	public static int addValue(int i) {
		if (i < 100) {
			i += 100;
		} else if (i >= 100) {
			i = 55;
		}
		return i;
	}
}