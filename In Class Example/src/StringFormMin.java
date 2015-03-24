import java.util.Scanner;

// HR: MIN

// parsing example

public class StringFormMin {

	public static void main(String[] args) {
		
		// declare variables
		String input;
		
		// getting string to parse
		Scanner scan = new Scanner(System.in);
		System.out.print("Time? ");
		input = scan.nextLine();
		
		// find the ':' delimiter
		// check each index from 0 (idx) then circle around
		// or take off while and have int idx = input.indexOf(':');
		int idx = 0;
		while (input.charAt(idx) != ':') {
			idx++;
		}
		System.out.println(input.charAt(idx));
		
		// extract hours
		String hours = input.substring(0, idx);
		System.out.println("Hours: " + hours);
		
		// extracts minutes
		String minutes = input.substring(idx + 1, input.length());
		System.out.println("Minutes: " + minutes);
		
		// print hrs and min

	}

}

