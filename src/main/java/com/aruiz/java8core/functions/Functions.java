package com.aruiz.java8core.functions;

import java.util.function.*;
public class Functions {

	Function<String, String> capping= (a) -> a.toUpperCase();
	
	public static void main(String... args) {
		Functions test = new Functions();
		System.out.println(test.capping.apply("mickey mouse"));
	}
}
