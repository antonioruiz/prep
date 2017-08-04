package com.aruiz.java8core.examplelambdas;

import java.util.concurrent.Callable;

public class Runnables {
	public void methodAcceptingRunnable(Runnable r){
		r.run();
	}
	public <T> T methodAcceptingCallable(Callable<T> c){
		T result = null;
		try {
			result =  c.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String... args){
		//Runnable runnable = ()-> System.out.println("Hello Lambda");
		Runnables myRunnables = new Runnables();
		myRunnables.methodAcceptingRunnable(()-> System.out.println("Hello Lambda"));
		myRunnables.methodAcceptingCallable(() -> {return "Hello Callable";});
		System.out.print(myRunnables.methodAcceptingCallable(() -> {return "Hello Callable";}));
		
	}

}
