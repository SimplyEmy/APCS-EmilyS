package Fraction_Class;

public class FracMain {

	public static void main(String[] args) {
		// declare variables
		Fraction x;
		
		x = new Fraction();
		
		x.numerator = 1;
		x.denominator = 2;

		printFrac(x);
	}
	
	static void printFrac(Fraction f) {
		System.out.println(f.numerator + "/" + f.denominator);
	}
}
