package com.aruiz.java8core;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DavisStairs {

	// Consumer<>

	public static int findPossibleways(int n) {

		if (n == 1 || n == 2) {
			return n;
		}
		if (n == 3) {
			return 4;
		}

		int possibleSteps = 0;
		Map<Integer, Integer> components = breakIntoLargestPossibleComponents(n);
		// Stream components = Stream.of(remainder);
		System.out.println(components);
		// components.forEach(System.out.println);
		possibleSteps = calculateResultsAndDisplay(components);

		return possibleSteps;

	}

	private static int calculateResultsAndDisplay(Map<Integer, Integer> components) {
		int possibleSteps =0;
		for (Entry<Integer, Integer> entry : components.entrySet()) {
			//System.out.printf("Calculating %d * the value of %d", entry.getKey(), entry.getValue());
			System.out.println();
			Integer tempResult = entry.getValue() * (findPossibleways(entry.getKey()));
			possibleSteps += tempResult;
		}
		return possibleSteps;
	}

	static Map<Integer,Integer> breakIntoLargestPossibleComponents(int n) {
		// TODO Auto-generated method stub
		int threes = n / 3;
		int twos = (n % 3) / 2;
		int ones = n - (3 * threes + 2 * twos);
		// System.out.printf("[%d ,%d,%d]",threes, twos, ones);
		Map<Integer, Integer> rep = new TreeMap<Integer, Integer>();

		rep.put(3, threes);
		rep.put(2, twos);
		rep.put(1, ones);
		return rep;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("3: " + findPossibleways(3));
		//System.out.println("4: " + findPossibleways(4));
		System.out.println("5: " + findPossibleways(5));
		//System.out.println("6:" + findPossibleways(6));
	}

}
