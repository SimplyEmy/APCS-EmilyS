package SetOfValues;

import java.util.Scanner;

public class MainProgram {
	// implements a simple calculator
	//
	// the main loop accepts commands in three forms:
	// * quit - to terminate
	// * <variable> = <int literal>
	// * <variable> = <variable> <operation> <variable>
	//
	// <variable> is a single upper case letter, from A to E
	// <operation> is +, -, * or /

	public static void main(String[] args) {

		// create a new object for Variables, with 5 variables
		SetOfValues v = new SetOfValues(8);

		// scanner for user input
		Scanner scan = new Scanner(System.in);

		// print current values, ask for a command
		v.print();
		System.out.print("? ");
		String cmd = scan.nextLine();
		while (!cmd.equalsIgnoreCase("quit")) {
			String upper = cmd.toUpperCase();
			
			// identify and execute command
			String[] words = cmd.split(" ");
			if (words.length == 3) {
				doValueAssignment(v, words);
			} else {
				doOperationAssignment(v, words);
			}

			// print current values, ask for a command
			v.print();
			System.out.print("? ");
			cmd = scan.nextLine();
		}
	}

	// assign a value to a variable
	static void doValueAssignment(SetOfValues v, String[] words) {
		// get variable name and value to assign
		char var = words[0].charAt(0);
		int value = Integer.parseInt(words[2]);

		// assign to the variable
		v.assign(var, value);
	}

	// do an operation and assign the result to a variable
	static void doOperationAssignment(SetOfValues v, String[] words) {
		// get variable names
		char varLeft = words[0].charAt(0);
		char varRight1 = words[2].charAt(0);
		char varRight2 = words[4].charAt(0);

		// get variable values
		int value1 = v.valueOf(varRight1);
		int value2 = v.valueOf(varRight2);

		// do operation
		int result;
		String op = words[3];
		if (op.equals("+")) {
			result = value1 + value2;
		}else if (op.equals("-")){
			result = value1 - value2;
		}else if (op.equals("*")){
			result = value1 * value2;
		}else{
			result = value1 / value2;
		}
		// assign the result to the variable
		v.assign(varLeft, result);
	}
}
