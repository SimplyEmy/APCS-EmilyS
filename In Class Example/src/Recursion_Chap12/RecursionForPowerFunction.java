package Recursion_Chap12;

public class RecursionForPowerFunction {
	// main function
	public static void main(String[] args) {
		// call recursive function and print result
		int n = multiply(2, 5);
		System.out.println("Answer: " + n);
	}

	// recursive implementation of multiplication
	// Multiplying to the power
	public static int multiply(int a, int b) {
		if (b == 0) {
			return 1;
		} else {
				
			int m1 = multiply(a, b - 1);
			int m2 = a * m1;
			
			return m2;
		}
	}
}
