package Fraction_Class2;

public class Fraction {

	// fields
	public int numerator;
	public int denominator;

	// constructor
	public Fraction(int n, int d) {
		numerator = n;
		denominator = d;
	}

	// simple print - just print improper, not simplified fraction
	public void simplePrint() {
		System.out.println(numerator + "/" + denominator);
	}

	// convert to String
	public String toString() {
		String s = numerator + "/" + denominator;
		return s;
	}

	// add 1 to the current fraction
	public void add1() {
		numerator += denominator;
	}

	// add whole number N to the current fraction
	public void addWhole(int n) {
		numerator += n * denominator;
	}

	// create a new fraction
	// that is the result of adding whole number N to current fraction
	public Fraction addWholeToCreateNewFraction(int n) {
		int newNum = numerator + n * denominator;
		Fraction f = new Fraction(newNum, denominator);
		return f;
	}

	// compare two fractions
	// return 1 if current is larger than "other"
	// return 0 if current is equal to "other"
	// return -1 if current is smaller than "other"
	public int compare(Fraction other) {
		// to compare two fractions, first rewrite them using a common
		// denominator,
		// then compare the two numerators
		// use the product of denominators as the common denominator

		// compute numerators based on the common denominator
		int newNumThis = numerator * other.denominator;
		int newNumOther = other.numerator * denominator;

		if (newNumThis > newNumOther)
			return 1;
		else if (newNumThis == newNumOther)
			return 0;
		else
			return -1;
	}

}
