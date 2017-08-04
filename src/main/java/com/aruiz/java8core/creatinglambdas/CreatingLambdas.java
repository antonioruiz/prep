package com.aruiz.java8core.creatinglambdas;

public class CreatingLambdas {
	
	interface Greeting{
		public String sayHello(String g);
	}
	public void testGreeting(String a, Greeting g) {
		String result = g.sayHello(a);
		System.out.println("Result:" + result);
	}
	
	public static void main(String[] args) {
		new CreatingLambdas().testGreeting("Harry",(String s) -> "Good morning, " + s);
		new CreatingLambdas().testGreeting("",(String s) -> {
			return "Good morning, " + (!s.isEmpty()?s:"Stranger");
		});  
		new CreatingLambdas().testGreeting("Sergio",(String s) -> {
			return "Good morning, " + (!s.isEmpty()?s:"Stranger");
		});
	}
}
