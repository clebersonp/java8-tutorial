package com.telusko.learning.method.reference;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		MyPrinter mp = new MyPrinter();
		String name = "cbn";
		mp.print(name, StringConverter::converter);
	}
}

class MyPrinter {
	public void print(String s, Parser p) {
		s = p.parser(s);
		System.out.println(s);
	}
}

interface Parser {
	String parser(String s);
}

class StringConverter {
	public static String converter(String s) {
		if (s.length() <= 3) {
			s = s.toUpperCase();
		} else {
			s = s.toLowerCase();
		}
		return s;
	}
}
