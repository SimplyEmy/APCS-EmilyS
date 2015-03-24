package SAVE_LOAD_ClassEx;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintStream;
	import java.util.Scanner;
	
public class SaveLoadEX {
		// implements a simple calculator
		//
		// the main loop accepts five commands:
		// * quit - to terminate
		// * <variable> = <int literal>
		// * <variable> = <variable> <operation> <variable>
		// * save <filename>
		// * load <filename>
		//
		// <variable> is a single upper case letter, from A to E
		// <operation> is +, -, * or /
		// <filename> is a valid file name without spaces

		
		public static void main(String[] args) {

			

			// scanner for user input
			Scanner scan = new Scanner(System.in);

		
			System.out.print("? ");
			String cmd = scan.nextLine();
			cmd = cmd.toUpperCase();
			while (!cmd.equals("QUIT")) {
				System.out.print("? ");
				cmd = scan.nextLine();
				cmd = cmd.toUpperCase();
			}

			// close console input
			scan.close();
		}

		// process command
		static void doCommand(SetOfValues v, String cmd) {
			// identify and execute command
			String[] words = cmd.split(" ");
			
			if (words[0].equals("LOAD")) {
				doLoad(words);
			}
		}
		

		// load values of variables to a file
		static void doLoad(String[] words) {
			// open file
			File f = new File(words[1]);
			Scanner input;
			try {
				input = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.out.println("Could not load.");
				return;
			}
			System.out.println(input);
				
			

			// close file
			input.close();
		}
}