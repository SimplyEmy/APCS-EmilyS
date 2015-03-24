package Recursion_Chap12;

public class Recursion {

	// main function
	public static void main(String[] args) {
		// call recursive function and print result
		int n = multiply(2, 3);
		System.out.println("Answer: " + n);
	}

	// recursive implementation of multiplication
	public static int multiply(int a, int b) {
		if (b == 0) {
			return 0;
		} else {
			
			int m1 = multiply(a, b - 1);
			
			System.out.println("M1: " + m1);
			
			int m2 = a + m1;
			
			System.out.println("M2: " + m2);
			
			System.out.println("a: " + a);
			System.out.println("b: " + b);
			System.out.println();
			
			return m2;
		}
	}

}
