

import java.time.LocalDate;
import java.time.format.*;

public class Cell {
	//Array
	//sType means String
	//dType means Date
	//vType means Value
	//using enum
	public enum CellType {sType, dType, vType, fType};
	
	//Setting Variables
	public CellType Type;
	public String str;
	public LocalDate dat;
	public double val;
	public String form;
	public double evalNum;
	
	//Date format
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	
	//Constructor 
	public Cell(String s){
		Set(s);
	}
	
	public Cell(char column, int row, String formula){
		formulaSet(column, row, formula);
	}
	
	public void Set(String s){
		try{
			this.dat = LocalDate.parse(s,formatter);
			this.Type = CellType.dType;
		}catch (DateTimeParseException A) {
			
			try{
				this.val = Double.parseDouble(s);
				this.Type = CellType.vType;
			}catch (NumberFormatException B){
				this.str = s;
				this.Type = CellType.sType;
			} 
		}
	}
	
	public void formulaSet(char column, int row, String input){
		//splitting input
		String[] words = input.split(" ");
		
		//getting final number
		double evalNum = Formula.ParsingNumFormula(words, input);
		
		//saving formula in:
		this.form = input;
		
		//saving value in val
		this.val = evalNum;
		
		//Setting type
		this.Type = CellType.fType;
	}
	
	// Represents the data in the cell as a string
	// and formats it according to a specified length
	// passed as a parameter
	public String toString(int length){
		String s = "";
		switch (Type) {
			//different types in case statements
			case dType: {
				s = String.format("%" + length + "s", dat.format(formatter));
				break;
			}
			case vType: {
				s = String.format("%" + length + "f", val);
				break;
			}
			
			case fType: {
				s = String.format("%" + length + "f", val);
				break;
			}
			
			default:
				s = str;
				break;
		}
		
		if (s.length() > length){
			return s.substring(0, length-1) + ">";
		}else{
			return s;
		}
	}
	
	// Represents the data in the cell as a string
	public String toString() {
			
		switch (Type) { 
		
		case dType:
			return dat.format(formatter); 
			
		case vType: 
			return Double.toString(val);
			
		case fType:
			return (form);
			
		default:
			return str;
		}		
	}

	
}


