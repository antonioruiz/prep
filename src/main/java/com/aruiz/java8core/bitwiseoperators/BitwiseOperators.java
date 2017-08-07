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
	
	public static void main(String ...args) {
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
		System.out.println("xor operation ...facts");
		System.out.println("xor operation ..with itself");
		xor = xorOperation.execute(op1, op1);
		ds.display(op1, op1, xor);
		System.out.println("xor an odd number of times... ");
		int temp = xorOperation.execute(xor, op1);
		ds.display(xor, op1, temp);
		
		System.out.println("xor an even number of times... ");
		xor = xorOperation.execute(temp, op1);
		ds.display(temp, op1, xor);
		
		System.out.println("xor with zero...");
		xor = xorOperation.execute(op1, 0);
		ds.display(op1, 0, xor);
		
		System.out.println("xor with all ones...");
		xor = xorOperation.execute(op1, 0xffff);
		ds.display(op1, 0xff, xor);
		System.out.println();
		
		System.out.println("xor with pairs but one...");
		xor = xorOperation.execute(10,20 );
		ds.display(10, 20, xor);
		temp = xorOperation.execute(xor, 30);
		ds.display(xor, 30, temp);
		xor = xorOperation.execute(temp, 40);
		ds.display(temp, 40, xor);
		temp = xorOperation.execute(xor, 30);
		ds.display(xor, 30, temp);
		xor = xorOperation.execute(temp, 20);
		ds.display(temp, 20, xor);
		temp = xorOperation.execute(xor, 40);
		ds.display(xor, 40, temp);
		System.out.println();
		
		System.out.println("swapping values of a and b wihtout a third tmp variable");
		System.out.printf("original values a=%d b=%d", op1, op2);
		op1 = xorOperation.execute(op1, op2);
		op2 = xorOperation.execute(op2, op1);
		op1 = xorOperation.execute(op2, op1);
		System.out.printf("\nafter swap values a=%d b=%d", op1, op2);
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
