import java.util.Scanner;

public class Program {
	
	//defining size of spreadsheet
	//and creating new spreadsheet "sheet"
	static int numcolumns = 10;
	static int numrows = 10;
	static Spreadsheet sheet = new Spreadsheet(numcolumns, numrows);
	public static String input;
	
	public static void main(String[] args){
		//Scanner to take in input
		Scanner scan = new Scanner(System.in);
		
		//printing out blank sheet before asking for input
		sheet.printSpreadsheet();
		
		//asking for input for user
		System.out.print("Enter Input: ");
		String input = scan.nextLine();
		
		//while loop checking if quit is true or false
		while(!input.equalsIgnoreCase("quit")){
			//sending input to parsing method
			sheet.parsing(input);
			 
			//printing new sheet with given input
			sheet.printSpreadsheet();
			
			//asking for more input (until quit)
			System.out.print("Enter Input: ");
			input = scan.nextLine();
		}
		//after quit gives goodbye statement
		System.out.println();
		System.out.println("Thank you for using my text excel! :) goodbye!");
		System.out.println();
		
		//closing scanner
		scan.close();
	}
}

	


