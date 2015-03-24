import java.util.Scanner;

// Program to find common factors

public class SimpDivisors {

	public static void main(String[] args) {
		// declare variables
				int n;
				int m;
				int c;
				boolean foundCommonFactor;
				int commonFactor;
				
				//get input number n and m
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter Number1: ");
				n = scan.nextInt();
				System.out.println("Enter Number2: ");
				m = scan.nextInt();
				
				//check each number c between 2 and n-1
				foundCommonFactor = false;
				commonFactor = 1;
				for (c = 2; c <= n; c++)
				
				{
					// if n % c == 0 (to know if c is a divisor) then print
					if (n % c == 0 && m % c == 0)
					{
						System.out.println();
						System.out.println(c + " is a factor of " + n + " and " + m);
						foundCommonFactor = true;
						commonFactor = c;
					}
					
				}
				// print result
				if (foundCommonFactor) {
					System.out.println();
					System.out.println("Common factor: " + commonFactor);
				}
				else {
					System.out.println();
					System.out.println("No common factor.");
				}
				System.out.println();
				System.out.println("all done!!");
			}
	}
		


