

public class Formula {
	
	public static boolean CheckingFormula(String words){
		//checking if cell or integer
		//first one in equation
		char isChar = words.charAt(0);   
		//System.out.println(isChar);
		if(isChar>=48 && isChar<=57){
			return false;
		}else{
			return true;
		}
	}
	public static double ParsingNumFormula(String words[], String formula){
		//setting variables
		double num1 = 0;
		double num2 = 0;
		double evalnum = 0;
		double numAnswer = 0;
		
		String value = words[0];
		//for loop to run through numbers in formula
		for (int i = 0; i < words.length; i++) {
			//goes through first two then uses that number and moves on
			if (i > 2){
				num1 = evalnum;
				
				if (words[i].equals("+") || words[i].equals("-") || words[i].equals("*") || words[i].equals("/")){
					//checking whether its a cell or number wanting to be operated
					if (CheckingFormula(words[i + 1]) == true){
						num2 = Spreadsheet.sheet[Spreadsheet.CharacterNum(words[i + 1].charAt(0))][Integer.parseInt(words[i + 1].substring(1))].val;
							
					}else{
						num2 = Integer.parseInt(words[i + 1]);	
					}
					//does the operation
					if	(words[i].equals("+")){
						evalnum = Adding(num1, num2);
					
					}else if (words[i].equals("-")){ 
						evalnum = Subtracting(num1, num2);
			
					}else if (words[i].equals("*")){ 
						evalnum = Multiplying(num1, num2);
						
					}else if (words[i].equals("/")){
						evalnum = Dividing(num1, num2);
					}
				}
					
			}else if (words[i].equals("+") || words[i].equals("-") || words[i].equals("*") || words[i].equals("/")){
				//checking whether its a cell or number wanting to be operated
				if (CheckingFormula(words[i - 1]) == true){
					num1 = Spreadsheet.sheet[Spreadsheet.CharacterNum(words[i - 1].charAt(0))][Integer.parseInt(words[i - 1].substring(1))].val;
					
				}else{
					num1 = Integer.parseInt(words[i - 1]);	
				}
				//checking whether its a cell or number wanting to be operated
				if (CheckingFormula(words[i + 1]) == true){
					num2 = Spreadsheet.sheet[Spreadsheet.CharacterNum(words[i + 1].charAt(0))][Integer.parseInt(words[i + 1].substring(1))].val;
					
				}else{
					num2 = Integer.parseInt(words[i + 1]);	
				}
			}
			//doing operation	
			if	(words[i].equals("+")){
				evalnum = Adding(num1, num2);
					
			}else if (words[i].equals("-")){ 
				evalnum = Subtracting(num1, num2);
			
			}else if (words[i].equals("*")){ 
				evalnum = Multiplying(num1, num2);
			
			}else if (words[i].equals("/")){
				evalnum = Dividing(num1, num2);
				
			}
		}
		//returning double	
		return evalnum;
	}
	
	public static double Adding(double num1, double num2){
		double numAnswer = num1 + num2;
		
		return numAnswer;
	}
	
	public static double Subtracting(double num1, double num2){
		double numAnswer = num1 - num2;
		
		return numAnswer;
	}
	
	public static double Multiplying(double num1, double num2){
		double numAnswer = num1 * num2;
		
		return numAnswer;
	}
	
	public static double Dividing(double num1, double num2){
		double numAnswer = num1 / num2;
		
		return numAnswer;
	}
	
	public static String SUM(String words[]){
		//initializing variables
		boolean empty;
		double answerNum = 0;
		String returnAns;
		
		//get starting values
		//changing rows and columns to integer
		int StartColumn = Spreadsheet.CharacterNum(words[3].charAt(0));
		int StartRow = Integer.parseInt(words[3].substring(1, 2));
		int EndColumn = Spreadsheet.CharacterNum(words[3].charAt(3));
		int EndRow =  Integer.parseInt(words[3].substring(4));
		
		// Calculate the number of columns, rows & total cells from the coordinates given
		int numcols = EndColumn - StartColumn + 1;
		int numrows = EndRow - StartRow + 1;
		int numcells = numrows * numcols;		
		
		// Creating initial boolean for empty 
		empty = false;
				
		//for loop to loop through cells
		for(int j = 0; j < numcells; j++){
			double num = 0;
			//check if cell is null
			if (Spreadsheet.sheet[j%numcols+(StartColumn - Spreadsheet.CharacterNum('A'))][j/numcols+(StartRow - Spreadsheet.CharacterNum('A'))] == null){
				empty = true;
			
			//if cell is not null to add
			}else if (empty == false){
				num = Spreadsheet.sheet[j%numcols+(StartColumn - Spreadsheet.CharacterNum('A'))][j/numcols+(StartRow- Spreadsheet.CharacterNum('A'))].val;
				//Adding to answer before
				answerNum = answerNum + num;
			}
		} 
		//if cell is null it will print this statement
		if (empty == true){
			returnAns = "nullcell";
		
		//else it will set the Cell as the sums answer
		} else {
			returnAns = answerNum + "";
		}
		
		return returnAns;
	}
	
	public static String AVG(String words[]){
		String returnAns;
		//get starting values
		//changing rows and columns to integer
		int StartColumn = Spreadsheet.CharacterNum(words[3].charAt(0));
		int StartRow = Integer.parseInt(words[3].substring(1, 2));
		int EndColumn = Spreadsheet.CharacterNum(words[3].charAt(3));
		int EndRow =  Integer.parseInt(words[3].substring(4));
		
		// Calculate the number of columns, rows & total cells from the coordinates given
		int numcols = EndColumn - StartColumn + 1;
		int numrows = EndRow - StartRow + 1;
		int numcells = numrows * numcols;
		
		//Getting the added up numbers from SUM method (in String form)
		String sum = SUM(words);
		
		if (sum.equals("nullcell")){
			returnAns = "nullcell";
		}else{
			//Changing the string to a double
			double numbersAdded = Double.parseDouble(sum);
		
			//Dividing sum of range divided by number of cells
			double avgAnswer = numbersAdded / numcells;
		
			//making a string to send back
			returnAns = avgAnswer + "";
		}
		
		return returnAns;
	}
}
