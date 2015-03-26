package Recursion_Chap12;

public class Recursion {

	// main function
	public static void main(String[] args) {
		// call recursive function and print result
		
		// multiplying numbers
		//int n = multiply(2, 3);
		
		// multiplying to the power
		//int n = power(2, 5);
		
		// printing line of stars
		//printLine(5);
		
		// reversing letters
		Reverse("abcd");
		
		// if need to print with n
		//System.out.println("Answer: " + n);
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
	
	// Multiplying to the power
	public static int power(int a, int b) {
		if (b == 0) {
			return 1;
		} else {
					
			int m1 = power(a, b - 1);
			int m2 = a * m1;
				
			return m2;
		}
	}
	
	// recursive implementation of printing out a line of stars
	public static void printLine(int a) {
		if (a == 0) {
			System.out.println();
		} else {
			System.out.print("*");
			printLine(a - 1);
		}
	}
	
	// Reversing string of letters
	public static void Reverse(String idx) {
		if(idx.length() == 0){
			System.out.println();
		} else {
			System.out.print(idx.charAt(idx.length() - 1));
			Reverse(idx.substring(0, idx.length() - 1));
		}
			
					
			
	}
}

