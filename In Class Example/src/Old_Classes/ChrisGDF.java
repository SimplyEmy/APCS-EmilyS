package Old_Classes;

//import scanner
import java.util.Scanner;

public class ChrisGDF {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Dividend: ");
		int dividend = scan.nextInt();
		
		System.out.print("Divisor: ");
		int divisor = scan.nextInt();
		
		int a = dividend;
		int b = divisor;
		int GCF;
		int numerator;
		int denominator;
		int dividend2;
		
		int whole = dividend/divisor;
		dividend2 = dividend-(divisor*whole);
		
		//division for the whole number
		while(a != 0 && b != 0){
			a = a % b;
			//System.out.println(a + "a")
			if (a != 0 && b != 0){
				b = b % a;
				//System.out.println(b + "b");
			}
		}
		//Finding greatest common denominator 
		
		if (a == 0) {
			//System.out.println("the GCD is" + b);
			GCF = b;
			
			numerator = dividend2/GCF;
			denominator = divisor/GCF;
			
			if(numerator != 0){
				System.out.println(dividend + "/" + divisor + " is equal to " + whole + "_" + numerator + "/" + denominator);
			}else{
				System.out.println(dividend + "/" + divisor + " is equal to " + whole);
			}
		}else if (b == 0){
			//System.out.println("the GCD is " + a);
			GCF = a;
			
			numerator = dividend/GCF;
			denominator = divisor/GCF;
			
			if (numerator != 0){
				System.out.println(dividend + "/" + divisor + " is equal to " + whole + "_" + numerator + "/" + denominator);
			}else{
				System.out.println(dividend + "/" + divisor + " is equal to " + whole);
			}
		
		}
		scan.close();
	}

}
