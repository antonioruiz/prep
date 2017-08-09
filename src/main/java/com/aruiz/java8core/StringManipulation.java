package com.aruiz.java8core;

public class StringManipulation {

	public static String stringRev(String s){
		int lengthOfPreviousWord=0;
		for(int i=1; i<s.split(" ").length;i++){
			int indexOfLastWord = beginingOfLastWord(s);
			int secondHalf = i==1?0:s.substring(indexOfLastWord).length();
			s = s.substring(indexOfLastWord, s.length() + lengthOfPreviousWord) + " " + s.substring(secondHalf, indexOfLastWord).trim();
			System.out.println("iterating: "+s);
			lengthOfPreviousWord += s.substring(indexOfLastWord, s.length()).length();
			
		}
		
		return s;
	}
	
	private static int beginingOfLastWord(String s) {
		
		int j = s.length()-1;
		while(s.charAt(j)!= ' '){
			j--;
		}
		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringRev("The Sky is blue"));
	}

}

