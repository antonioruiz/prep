package com.aruiz.java8core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DavisStairs {

	public static int findPossibleways(int n) {

		List<String> components = new ArrayList<String>();
		Map<Integer, Integer> largestComponents = breakIntoLargestPossibleComponents(n, 3);
		
		List<String> initialFeed = calculateCombos(largestComponents);
		components.addAll(initialFeed);
		for(Entry<Integer, Integer> e:largestComponents.entrySet()){
			System.out.println("entry: " + e.getKey() +":"+e.getValue());
		}
		//from now on...substract and keep going
		/*
		while(largestComponents.size()>0 && n-1>0){
			largestComponents= breakIntoLargestPossibleComponents(n-1, 3);
			List<String> continuousFeed = calculateCombos(largestComponents);
			components.addAll(continuousFeed );
		}
*/
		
		System.out.println("components: " + components);
		Optional<String> optConcat = components.stream()
		.reduce((a,b)-> b.concat("+").concat(a));
		System.out.println("consolidated components: " + optConcat.get());
		
		return components.size();
	}

	private static List<String> calculateCombos(Map<Integer, Integer> componentsAsMap) {
		
		List<String> components = componentsAsMap.entrySet().stream()
			.map(e -> String.join("+", Collections.nCopies(e.getValue(), String.valueOf(e.getKey()))))
			.collect(Collectors.toList());
		
		return components;
	}

	static Map<Integer, Integer> breakIntoLargestPossibleComponents(int n, int initValue) {

		int threes = n / 3;
		int twos = (n % 3) / 2;
		int ones = n - (3 * threes + 2 * twos);
		//System.out.printf("[%d ,%d,%d]",threes, twos, ones);
		//System.out.println();
		Map<Integer, Integer> rep = new TreeMap<Integer, Integer>();
		
		if(threes>0){
			rep.put(3, threes);
		}
		if(twos>0){
			rep.put(2, twos);
		}
		if(ones>0){
			rep.put(1, ones);
		}
		
		return rep;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("2:" + findPossibleways(2));
		//System.out.println("3: " + findPossibleways(3));
		//System.out.println("4: " + findPossibleways(4));
		//System.out.println("5: " + findPossibleways(5));
		// System.out.println("6:" + findPossibleways(6));
		//System.out.println("7:"  + findPossibleways(7));
		//System.out.println("8:" + findPossibleways(8));
		//System.out.println("10:" + findPossibleways(10));
		//System.out.println("11:" + findPossibleways(11));
		//System.out.println("12:" + findPossibleways(12));
		//System.out.println("13:" + findPossibleways(13));
	}

}
