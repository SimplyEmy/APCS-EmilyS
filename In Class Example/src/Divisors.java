import java.util.*;

public class Divisors {

	public static void main(String[] args) {
		
		// declare variables
		int n;
		int c;
		
		//get input number n
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number to examine: ");
		n = scan.nextInt();
		
		//check each number c between 2 and n-1
		c = 2;
		while (c < n)
		{
			// if n % c == 0 (to know if c is a divisor) then print
			if (n % c == 0)
			{
				System.out.println(c + " is a factor of " + n);
			}
			
			
			c = c+1; //c++ 
		}
		// say goodbye
		System.out.println("all done!!");
	}
}