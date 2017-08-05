package com.aruiz.java8core.bitwiseoperators;

public class BitwiseOperators {
	
	@FunctionalInterface
	interface BinaryOperation{
		int execute(int a, int b);
	}
	
	@FunctionalInterface
	interface UnaryOperation{
		int execute(int a);
	}
	
	@FunctionalInterface
	interface DisplaySummary{
		void display(int a, int b, int c);
	}
		
	private DisplaySummary ds;
	
	public static void main(String ...args) {
		//BitwiseOperators bwo = new BitwiseOperators();
		DisplaySummary ds;
		
		BinaryOperation andOperation = (a,b) -> a&b;
		BinaryOperation xorOperation = (a,b) -> a^b;
		BinaryOperation orOperation = (a,b) -> a|b;
		int op1 = 12;
		int op2 = 16;
		//and
		System.out.println("and operation...");
		int and = andOperation.execute(op1, op2);
		ds = (a,b,c) -> System.out.printf("a=%d b=%d a-binary=%s b-binary=%s result=%d result-binary=%s\n", 
				a, b, Integer.toBinaryString(a), Integer.toBinaryString(b),and,Integer.toBinaryString(c));
		ds.display(op1, op2, and);
		//bwo.displaySummary(op1,op2, and, bwo.ds);
		//or
		System.out.println("or operation...");
		int or = orOperation.execute(op1, op2);
		ds = (a,b,c) -> System.out.printf("a=%d b=%d a-binary=%s b-binary=%s result=%d result-binary=%s\n", 
				a, b, Integer.toBinaryString(a), Integer.toBinaryString(b),c,Integer.toBinaryString(c));
		ds.display(op1, op2, or);
		//xor
		System.out.println("xor operation...");
		int xor = xorOperation.execute(op1, op2);
		ds = (a,b,c) -> System.out.printf("a=%d b=%d a-binary=%s b-binary=%s result=%d result-binary=%s\n", 
				a, b, Integer.toBinaryString(a), Integer.toBinaryString(b),c, Integer.toBinaryString(c));
		ds.display(op1, op2, xor);
		
		System.out.println();
		System.out.println("======== UNARY OPERATIONS =======");
		//negate
		System.out.println("negate operation");
		UnaryOperation negateOperator = a -> ~a;
		int negate = negateOperator.execute(op1);
		ds = (a,b,c) -> System.out.printf("a=%d a-binary=%s result=%d result-binary=%s\n", 
				a, Integer.toBinaryString(a) ,c ,Integer.toBinaryString(c));
		ds.display(op1, 0, negate);
	}
}
