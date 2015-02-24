

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Import_Export {
	

	//Method to Import a file	
	public static void Import(String[] words) {
		// open File
		//place in word array where file name is to Import	
		File f = new File(words[1]);
		Scanner input = null;
					
		try {
			input = new Scanner(f);
					
		//if the file does not exist
		} catch (FileNotFoundException F) {
			System.out.println("Could not import file");
			return;
		}
				
		//finding dimensions
		String dimension =  input.nextLine();
				
		String[] dims = dimension.split(" ");
		
		Spreadsheet.cellwidth = Integer.parseInt(dims[2]);
					
		Program.sheet = new Spreadsheet(Integer.parseInt(dims[0]), Integer.parseInt(dims[1]));
					
		//loop until no more input, boolean
		while (input.hasNext()) {
			String assign = input.nextLine();
			String[]  idx = assign.split(" ");
						
			//parsing string into an integer
			int y = Integer.parseInt(idx[0]); //column
			int x = Integer.parseInt(idx[1]); //row
					
			String value = idx[2];
			for (int i = 3; i < idx.length; i++) {
				value = value + " " + idx[i];
			}
			//setting to new sheet
			Program.sheet.Set((char) (y + 65), x, value); //printing column, row, info
		}
	}
			
	//Method to Export a file
	public static void Export(String[] words) {
		// set up output file
		File f = new File(words[1]);
		PrintStream output = null;
			
		try {
			output = new PrintStream(f);
			//going to add number of columns, rows and the cellwidth in case it was changed
			output.println(Integer.toString(Program.numcolumns) + " " + 
					Integer.toString(Program.numrows) + " " + Integer.toString(Spreadsheet.cellwidth));
						
			// x = rows, y = columns
			//printing table
			for (int x = 0; x < Program.numrows; x++) {
				for (int y = 0; y < Program.numcolumns; y++) {
								
					if(Spreadsheet.sheet[y][x] == null) {
						
					} else {
						output.println( y + " " +  x + " " + Spreadsheet.sheet[y][x].toString());
					}
				}
			}
			//print statement if file exported
			System.out.println("File Exported");
						
		} catch (FileNotFoundException E) {
			System.out.println("Cannot export file.");
			E.printStackTrace();
		}
			
		output.close();
	}
}
