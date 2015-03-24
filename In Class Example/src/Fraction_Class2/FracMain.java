package Fraction_Class2;

public class FracMain {

	// main method
	public static void main(String[] args) {

		// create a fraction
		Fraction x = new Fraction(1, 3);

		// print the fraction
		x.simplePrint();

		// get a string from the fraction, then print
		String xStr = x.toString();
		System.out.println("The value of x is " + xStr + ".");

		// add 1, then print
		x.add1();
		System.out.println("Call add1(), new value of x is " + x.toString()
+ ".");

		// add -1, then print
		x.addWhole(-1);
		System.out.println("Call addWhole(-1), new value of x is "
+ x.toString() + ".");

		// create a new fraction by adding 2 to x, print it
		Fraction y = x.addWholeToCreateNewFraction(2);
		System.out.print("Build y by adding 2 to x. ");
		System.out.println("The value of y is " + y.toString() + ".");

		// now compare x to y, and y to x
		System.out.println("Compare " + x.toString() + " to " + y.toString()
+ " is " + x.compare(y) + ".");
		System.out.println("Compare " + y.toString() + " to " + x.toString()
+ " is " + y.compare(x) + ".");
	}
}

