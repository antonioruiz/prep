package com.aruiz.java8core;

import java.util.Scanner;

public class StringManipulation {

	
	private String reverse(String s) {
		int numWords = s.split(" ").length;
		if(numWords==2 || numWords==1){
			//base case
			if(numWords == 1){
				return s;
			}
			return (s.split(" ")[1] + " " + s.split(" ")[0]);
		}
		int indexOfLastSeparator = s.lastIndexOf(" ");	
		return s.substring(indexOfLastSeparator, s.length()) + " "+reverse(s.substring(0, indexOfLastSeparator));
		
	}

	public static void main(String[] args) {

		Scanner readLine = new Scanner(System.in);
		System.out.print("enter string to reverse:");
		String lineToReverse =readLine.nextLine();
		System.out.println("Reversed: " + new StringManipulation().reverse(lineToReverse));
	}

}
