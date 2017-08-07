package com.aruiz.java8core.bitwiseoperators;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsesOfBitwiseOperators {
	
	public static void main(String... args){
		new UsesOfBitwiseOperators().AllRepeatedButOne();
	}

	private void AllRepeatedButOne() {
		IntStream allRepeatsButOne = IntStream.of(2, 8, 34, 10, 8, 2, 34);
		OptionalInt xor = allRepeatsButOne
		.reduce((a,b)-> a^b);
		if(xor.isPresent()){
			System.out.println(xor.getAsInt());
		}
		
		Stream<Integer> allrepeatsButOne2 = Stream.of(2, 8, 34, 10, 8, 2, 34);
		Optional<String> toString = allrepeatsButOne2
				.map(String::valueOf)
				.reduce((a,b)-> a+","+b);
		System.out.println(toString);
	}

}
