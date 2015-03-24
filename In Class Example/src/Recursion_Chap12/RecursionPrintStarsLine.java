package Recursion_Chap12;

public class RecursionPrintStarsLine {
	// main function
	public static void main(String[] args) {
		// call recursive function and print result
		printLine(5);
	}

	// recursive implementation of multiplication
	public static void printLine(int a) {
		if (a == 0) {
			System.out.println();
		} else {
			System.out.print("*");
			printLine(a - 1);
		}
	}
}
