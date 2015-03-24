import java.util.Scanner;

// reverse words in s string

// note: in notability with string 

public class StringReverse {

	public static void main(String[] args) {
		
		// declare variables
		String original;
		String word;
		String reverse;
		int start;
		int blank;
		
		// set up
		Scanner scan = new Scanner(System.in);
		System.out.print("String? ");
		original = scan.nextLine();
		
		// find all the words
		reverse = "";
		start = 0;
		blank = original.indexOf(' ');
		
		while (blank != -1) {
			word = original.substring(start, blank);
			reverse = " " + word + reverse;
			// System.out.println(reverse);
			
			start = blank + 1;
			blank = original.indexOf(' ', start);
			
		}
		word = original.substring(start);
		reverse = word + reverse;
		System.out.println(reverse);
	}

}
