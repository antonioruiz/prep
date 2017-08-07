package com.aruiz.java8.core.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreatingStreams {
	
	//From Collections
	private void testCollectionStreams(){
		
	}
	//Empty stream
	private void testEmptyStreams(){
		Stream<String> names = Stream.empty();
		System.out.println("Empty stream: "+names.count());
	}
	//From values/arrays
	private void testStreamsFromValues(){
		Stream<String> names = Stream.of("Jorge","Elias","Mike", "Josh");
		System.out.println("Names stream: " + names.count());
		Stream<Integer> numbers = Stream.of(1,2,3,4,5,6);
		System.out.println("Numbers stream: " + numbers.count());
		Integer[] integers ={5,8,9,1,2,4};
		Stream<Integer> integersStream = Stream.of(integers);
		System.out.println("integers stream: " + integersStream.count());
	}
	//From a file
	private void testFileStream(){
		try {
			Stream<String> fileLines = Files.lines(Paths.get("/home/anapaulinaf/tmp.txt"));
			fileLines
			.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//generate/iterate values
	private void testGenerateIterate() {
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream
			.map(d -> Math.round(d*100))
			.filter(d -> 1.0<=d && d<=40.0)
			.limit(10)
			.forEach(System.out::println);
		Stream<Integer> integerStream = Stream.iterate(1, f -> f*2);
		integerStream
		.limit(30)
		.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		new CreatingStreams().testCollectionStreams();
		new CreatingStreams().testEmptyStreams();
		new CreatingStreams().testStreamsFromValues();
		new CreatingStreams().testFileStream();
		new CreatingStreams().testGenerateIterate();
	}

}
