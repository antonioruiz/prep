package com.aruiz.java8core;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solutions {

	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);

		System.out.println("enter values");
		int myInt = scan.nextInt();
		
		System.out.println(myInt*2);
		myInt = scan.nextInt();
		System.out.println(myInt*3);
		String line =scan.nextLine();
		System.out.println(line);*/
		int[] ints={2,7,8,12,90,12};
		IntStream intsStream = IntStream.of(ints);
		boolean result= intsStream.anyMatch(i->i==12);
		
		IntStream range = IntStream.rangeClosed(3, 12);
		range
		.filter(odd -> odd%2==0)
		.forEach(System.out::println);
		
		int[][] maze ={{1,1,1},{1,1,1},{1,1,1},{3,3,3}};
		
		System.out.println("dimensions " + maze.length +"x" +maze[0].length);
	}
}
