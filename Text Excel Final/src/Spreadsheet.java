

import java.io.*;
import java.util.Scanner;

public class Spreadsheet {
	//setting values
	static int cellwidth = 9;
	public static int columns;
	public static int rows;

	//calling array
	//"sheet" is an array of cells
	public static Cell[][] sheet;
	
	//spreadsheet constructor
	public Spreadsheet(int c, int r){
		this.columns = c;
		this.rows = r;
		this.sheet = new Cell[c][r];
	}
	
	// Method that sets the properties of the cell
	// If the cell doesn't have anything in it, the method creates a new cell
	// If the cell already exists, it redefines its properties
	public void Set(char column, int row, String x) {
		//if cell is null
		if (this.sheet[CharacterNum(column)][row] == null) {
			//if Date
			if(x.indexOf("/") != -1 && x.indexOf("/") == 1){
				this.sheet[CharacterNum(column)][row] = new Cell(x);
			
			//if formula
			}else if(x.indexOf("+") != -1 || x.indexOf("-") != -1 || x.indexOf("*") != -1 || x.indexOf("/") != -1){
				this.sheet[CharacterNum(column)][row] = new Cell(column, row, x);
			
			//if not formula 
			}else{
				this.sheet[CharacterNum(column)][row] = new Cell(x);
			}
		//if cell is not null
		} else {
			//if Date
			if(x.indexOf("/") != -1 && x.indexOf("/") == 1){
				this.sheet[CharacterNum(column)][row] = new Cell(x);
			//if formula
			}else if(x.indexOf("+") != -1 || x.indexOf("-") != -1 || x.indexOf("*") != -1 || x.indexOf("/") != -1){
				this.sheet[CharacterNum(column)][row].formulaSet(column, row, x);
			//if niether formula or date
			}else{	
				this.sheet[CharacterNum(column)][row].Set(x);
			}
		}
	}
	
	//finding the number that represents the letter wanted 
	//number to place in array
	public static int CharacterNum(char c) {
		int charnum = Character.getNumericValue(Character.toUpperCase(c)) - Character.getNumericValue('A');
		return charnum;
	}
	
	//parsing input taken 
	//and using switch statement to determine what to do with input
	public void parsing(String input){
		
		//splitting input
		String[] words = input.split(" ");
		
		//find what user is saying in input
		switch (words[0]){
		
		//clearing individual cell or entire spreadsheet
		//different cases of what input is 
		case "clear":
			if (words.length == 1) {
				Program.sheet.Clear();
					
			} else if (words.length == 2) {
				//checking if it is a valid address
				if (validAddress(words[1]) == false) {
					System.out.println(words[1] + " is not a valid cell address.");
					
				} else {	
					Program.sheet.Clear(words[1].charAt(0), Integer.parseInt(words[1].substring(1))); 	
				}
			}
					
			break;
			
		//if changing width of cells
		case "width":
			
			cellwidth = Integer.parseInt(words[1]);
			
			break;
		
		//ascending sort
		case "sorta":
			
			Sorting.sortA(words);
			
			break;
			
		//descending sort
		case "sortd":
			
			Sorting.sortD(words);
			
			break;
		
		//calls importing and exporting class
		case "export":
			
			Import_Export.Export(words);
			
			break;
			
		case "import":
			
			Import_Export.Import(words);
			
			break;
		
		//if you want to assign data to a cell you type cell <cell number> = data
		//strings, dates and integers/doubles 	
		case "cell":
			//if length of input is only one	
			if (words.length == 2) {
				
				if (validAddress(words[1]) == true) {
					// if the wanted cell info doesn't have anything in it
					if (GettingCellInfo(words[1]) == null) {
						System.out.println("That cell doesn't have anything in it!");
					
					} else { 
						System.out.println(GettingCellInfo(words[1]));
					}
				}
				//checking if this is a valid address
				if (validAddress(words[1]) == false) {
					System.out.println(input + " is not a valid cell address.");
				}
				
			} else if (words.length > 2) {
				//checking validity, if correct sets the data to the cell
				if (validInput(words) == true) {
					Program.sheet.Set(words[1].charAt(0), Integer.parseInt(words[1].substring(1)), words[3].substring(0));
					
				//else it will say what is wrong
				}else if (validAddress(words[1]) == false) {
					System.out.println(words[1] + " is not a valid cell address.");
					
				} else {
					System.out.println(input + " is not a valid input");
				}
			}
				break;
			
		// Input that deals with adding property to a cell 
		default:
		//with this default you cant assign anything besides formulas
		//but you can put just a cell number (ex. A6) and tell you what is in that cell
			//checking if length 1 
			if (words.length == 1) {
				if (validAddress(words[0]) == true) {
					// if the wanted cell info doesn't have anything in it
					if (GettingCellInfo(words[0]) == null) {
						System.out.println("That cell doesn't have anything in it!");
					
					//otherwise it will print the cell info	
					} else { 
						System.out.println(GettingCellInfo(words[0]));
					}
				}
				//checking if this is a valid address
				if (validAddress(words[0]) == false) {
					System.out.println(input + " is not a valid cell address.");
				}	
			
			} else if (words.length == 3){
				//checking validity, if correct sets the data to the cell
				if (validInput2(words) == true) {
					Program.sheet.Set(words[0].charAt(0), Integer.parseInt(words[0].substring(1)), words[2].substring(0));
					
				//else it will say what is wrong
				}else if (validAddress(words[0]) == false) {
					System.out.println(words[0] + " is not a valid cell address.");
					
				} else {
					System.out.println(input + " is not a valid input");
				}
				//checking if this is a valid address
				if (validAddress(words[0]) == false) {
					System.out.println(input + " is not a valid cell address.");
				}
		
			} else if (words.length > 1) {
				//if wanting to do SUM
				if(words[2].equals("SUM")){
					String Answer = Formula.SUM(words);
					//error handling if cell range has a null
					if(Answer.equals("nullcell")){
						System.out.println("There is a cell without a number within it.");
					}else{
						Program.sheet.Set(words[0].charAt(0), Integer.parseInt(words[0].substring(1)), Answer);
					}
					
				//if wanting to do AVG
				}else if (words[2].equals("AVG")){
					String Answer = Formula.AVG(words);
					//error handling if cell range has a null
					if(Answer.equals("nullcell")){
						System.out.println("There is a cell without a number within it.");
					}else{
						Program.sheet.Set(words[0].charAt(0), Integer.parseInt(words[0].substring(1)), Answer);
					}
				//Means this is a formula
				}else if (validAddress(words[0]) == false) {
					System.out.println(words[0] + " is not a valid cell address.");
				} 
				if (validEquals(words[1]) == false) {
					System.out.println(input + " is not a valid input");
				}
				if (words[3].equals("+") || words[3].equals("-") || words[3].equals("/") || words[3].equals("*")){
					String formula = input.substring(5);
					//System.out.println(formula);
					Program.sheet.Set(words[0].charAt(0), Integer.parseInt(words[0].substring(1)), formula);
				
				//checking validity, if correct sets the data to the cell
				}else if (validInput2(words) == true && !words[2].equals("SUM") && !words[2].equals("AVG")) {
						Program.sheet.Set(words[0].charAt(0), Integer.parseInt(words[0].substring(1)), words[2].substring(0));
				}	
			}
			break;	
		}
	}
	//Method for getting cell info (in Cell Form)
	public static Cell GettingCellInfo(String Address){
		Cell info = sheet[CharacterNum(Address.charAt(0))][Integer.parseInt(Address.substring(1))];
		
		return info;
		
	}
	//Method for getting cell info (in String form)
	/*public static String GettingCellInfoString(String Address){
		String info = sheet[CharacterNum(Address.charAt(0))][Integer.parseInt(Address.substring(1))].str;
		
		return info;
	}*/
	
	//testing if address is correct or not
	public boolean validAddress(String address) {
		
		if (CharacterNum(address.charAt(0)) > this.columns) {
			return false;
		}
		
		try {
			int x = Integer.parseInt(address.substring(1)); 
			if (x > this.rows) {
					return false;
			} 
			
		} catch (NumberFormatException C) {
			return false;
		}
		
		return true;
	}
	// Tests if the input is valid when it contains multiple words
	public boolean validInput(String[] string) {
		if (validAddress(string[1]) == false) {
			return false;
		}
			
		if (validEquals(string[2]) == false) {
			return false;
		}
		
		return true;
	}
	// Tests if the input is valid when it contains multiple words
	public boolean validInput2(String[] string) {
		//checking the Adress
		if (validAddress(string[0]) == false) {
			return false;
		}
		//checking the equals		
		if (validEquals(string[1]) == false) {
			return false;
		}
		
		return true;
	}
	
	// Testing if the equals portion of the cell declaration is valid
	public boolean validEquals(String portion) {
		//seeing if it has an equals sign	
		if (!portion.equals("=")) {
			return false;
				
		} else {
			return true;
		}
	}
	
	//clearing the whole spreadsheet
	public void Clear(){
		//for loops to run through array
		for (int x = 0; x < this.rows; x++) {
			for (int y = 0; y < this.columns; y++) {
				this.sheet[y][x] = null;
			}
		}
	}
	
	//clearing only an individual cell
	public void Clear(char col, int row) {
		//using number from CharacterNum Method
		this.sheet[CharacterNum(col)][row] = null;
	}	
		
	//creating the dashes to separate rows
	public void RowSep(){
		for(int x = 1; x <= ((this.cellwidth+1)*(this.columns+1)+1); x++){
			System.out.print("-");
		}
		System.out.println();
	}
	
	//to print Spreadsheet 	
	public void printSpreadsheet(){	
		RowSep();
		//Print top row with Alphabet
		//Prints first box on first row
		System.out.print("|");	
		System.out.printf("%" + cellwidth + "s", " ");
		System.out.print("|");
			
		//prints to end of first row
		for(int i = 0; i < columns; i++){
			System.out.printf("%" + cellwidth + "s", (char) (i + 65));
			System.out.print("|");
					
		}
		System.out.println();
		//printing the dashes in between
		RowSep();
			
		//printing rows
		//Printing the numbers on left
		for(int j = 1; j < rows; j++){
			System.out.print("|");	
			System.out.printf("%" + cellwidth + "s", j);
			System.out.print("|");
				
			//printing the rows
			for(int i = 0; i < columns; i++){
				if(i < this.columns){
					//checking if cell is null or not
					if(this.sheet[i][j] != null){
						System.out.printf("%" + cellwidth + "s", this.sheet[i][j].toString(cellwidth));
						System.out.print("|");
							
					}else{
						System.out.printf("%" + cellwidth + "s", " ");
						System.out.print("|");
					}
				}	
			}
			System.out.println();
			RowSep();
		}
	}
}
	


