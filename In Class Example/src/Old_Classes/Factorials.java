package Old_Classes;

import java.util.Scanner;

public class Factorials {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number to calculate its Factorial: ");
		int factorialBase = scan.nextInt();
		int factorialAnswer = 1;
		int idx = 1;
		
		do {
			
			factorialAnswer *= idx++;
			
		}while (idx <=factorialBase);
		
		System.out.println("Factorial of " + factorialBase + " is " + factorialAnswer );
		
		scan.close();

	}

}