package SetOfValues;

public class SetOfValues {

	// store a set of values
	// the names are access through "variable names"
	// variable names are upper case letters A, B, C, ...

	// data fields
	int[] var;

	// constructor
	public SetOfValues(int size) {
		var = new int[size];
	}

	// print the values of variables
	public void print() {
		// print each variable
		for (int i = 0; i < var.length; i++) {
			// find name of variable in position "i"
			char name = (char) (i + 'A');
			// print
			System.out.println(name + ": " + var[i]);
		}
	}

	// assign value to the variable, find array index based on variable name
	public void assign(char varName, int varValue) {
		int i = varName - 'A';
		var[i] = varValue;
	}

	// return value of variable, find array index based on variable name
	public int valueOf(char varName) {
		int i = varName - 'A';
		return var[i];
	}

}
