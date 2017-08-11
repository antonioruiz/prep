package com.aruiz.java8core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DavisStairs {

	public static int findPossiblewaysNonRec(int n) {

		List<String> listOfComponentsAsStrings = new ArrayList<String>();
		List<Map<Integer, Integer>> listOfComponents = new ArrayList<Map<Integer, Integer>>();
		Map<Integer, Integer> largestComponents = breakIntoLargestPossibleComponents(n);
		listOfComponents.add(largestComponents);
		
		String componentsAsString= calculateComponentsAsString(largestComponents);
		listOfComponentsAsStrings.add(componentsAsString);
		System.out.println("Initially list of components as string: " +listOfComponentsAsStrings);
		for(Entry<Integer, Integer> e:largestComponents.entrySet()){
			Map<Integer,Integer> subLargestComponents;
			int m= e.getKey();
			int NumberOfTimes = e.getValue();
			System.out.println(componentsAsString + " breaking:" + m);
			int smallerComponent=m;
			while(m>0 && smallerComponent>1 ){
				smallerComponent--;
				subLargestComponents = breakIntoLargestPossibleComponents(m, smallerComponent);
				//update subLargestComponents to contain previous components
				//subLargestComponents.put(m, subLargestComponents.get(m)==null?1:subLargestComponents.get(m));
				listOfComponents.add(subLargestComponents);
				componentsAsString =calculateComponentsAsString(subLargestComponents);
				listOfComponentsAsStrings.add(componentsAsString);
				System.out.println("smaller subcomponent: " + componentsAsString);
			}
		}
		//from now on...substract and keep going
		/*
		while(largestComponents.size()>0 && n-1>0){
			largestComponents= breakIntoLargestPossibleComponents(n-1, 3);
			List<String> continuousFeed = calculateCombos(largestComponents);
			components.addAll(continuousFeed );
		}
*/
		
		System.out.println("components: " + listOfComponentsAsStrings);
		System.out.println("String format: ");
		//displayComponents(ListOfComponentsAsStrings);
		return listOfComponentsAsStrings.size();
	}


	static String calculateComponentsAsString(Map<Integer, Integer> componentsAsMap) {
		Optional<String> components = componentsAsMap.entrySet().stream()
			.map(e -> String.join("+", Collections.nCopies(e.getValue(), String.valueOf(e.getKey()))))
			.reduce((a, b)->b.concat("+").concat(a));
		return components.get();
	}

	static Map<Integer, Integer> breakIntoLargestPossibleComponents(int n, int initValue){
		int newNumberToBreak = n- initValue;
		
		Map<Integer, Integer> local =breakIntoLargestPossibleComponents(newNumberToBreak);
		if(local.get(initValue%3)==null){
			local.put(initValue%3, 1);
		}else{
			local.put(initValue%3, local.get(initValue%3)+1);
		}
		return local;
	}

	static Map<Integer, Integer> breakIntoLargestPossibleComponents(int n) {
	
		int threes = n/ 3;
		int twos = (n % 3) / 2;
		int ones = n - (3 * threes + 2 * twos);
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

	static void findPossibleWays(int n){
		List<String>
		if(n==1){
			
			
		}
		
		//return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("2:" + findPossibleways(2));
		//System.out.println("2: " + findPossibleways(2));
		//System.out.println("3: " + findPossibleways(3));
		//System.out.println("4: " + findPossibleways(4));
		//System.out.println("5: " + findPossibleways(5));
		// System.out.println("6:" + findPossibleways(6));
		//System.out.pr
		//System.out.println("7:"  + findPossibleWays(7));
		//System.out.println("8:" + findPossibleways(8));
		//System.out.println("10:" + findPossibleways(10));
		//System.out.println("11:" + findPossibleways(11));
		//System.out.println("12:" + findPossibleways(12));
		//System.out.println("13:" + findPossibleways(13));
        System.out.println("enter the number of calculations: ");
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        
        
        for(int a0 = 0; a0 < s; a0++){
           System.out.println("enter value of number of stairs:");
           int n = in.nextInt();
           //System.out.println(findPossibleways(n));
           findPossibleWays(n);
        }
        
        
	}

}
