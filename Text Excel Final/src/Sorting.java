public class Sorting {
	
	public static void sortD(String[] words) {
		//get starting values
		//changing rows and columns to integer
		int StartColumn = Spreadsheet.CharacterNum(words[1].charAt(0));
		int StartRow = Integer.parseInt(words[1].substring(1, 2));
		int EndColumn = Spreadsheet.CharacterNum(words[1].charAt(3));
		int EndRow =  Integer.parseInt(words[1].substring(4));
		
		// Calculate the number of columns, rows & total cells from the coordinates given
		int numcols = EndColumn - StartColumn + 1;
		int numrows = EndRow - StartRow + 1;
		int numcells = numrows * numcols;
		
		// Creating initial swap boolean
		boolean swapped = false;
		
		// creating a temp cell
		Cell temp;
		
		for(int i = 0; i < numcells-1; i++){
			
			swapped = false;
			
			for(int j = numcells-1; j > i; j--){
				if (Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow].val > Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow].val) {
					
					// Make the swap
					temp = Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow];
					Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow] = Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow];
					Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow] = temp;
					
					// Set the flag indicating that we did to a swap on this pass through the inner loop
					swapped = true;
				}
			} 
			
			// Before starting the next iteration on the outer loop, verify that we did a swap in the last one
			if (swapped == false) {
				// If we did not do a swap in the last pass, go ahead and quit because we're done
				break;
			}
		} 
	}
	public static void sortA(String[] words) {
		//get starting values
		//changing rows and columns to integer
		int StartColumn = Spreadsheet.CharacterNum(words[1].charAt(0));
		int StartRow = Integer.parseInt(words[1].substring(1, 2));
		int EndColumn = Spreadsheet.CharacterNum(words[1].charAt(3));
		int EndRow =  Integer.parseInt(words[1].substring(4));
		
		// Calculate the number of columns, rows & total cells from the coordinates given
       	int numcols = EndColumn - StartColumn + 1;
       	int numrows = EndRow - StartRow + 1;
       	int numcells = numrows * numcols;
       	
       // Creating initial swap boolean
       boolean swapped = false;
       	
       // creating a temp cell
       // to hold integer you are switching
       Cell temp;
       
       for(int i = 0; i < numcells-1; i++){
      		
      		swapped = false;
           	
      		for(int j = numcells-1; j > i; j--){
      			if (Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow].val < Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow].val) {

      				// Make the swap
      				temp = Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow];
      				Spreadsheet.sheet[(j/numrows)+StartColumn][(j%numrows)+StartRow] = Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow];
      				Spreadsheet.sheet[((j-1)/numrows)+StartColumn][((j-1)%numrows)+StartRow] = temp;
      				
      				// Set the flag indicating that we did to a swap on this pass through the inner loop
      				swapped = true;
      			}
      		} // End Sort Ascending
      	
      		// Before starting the next iteration on the outer loop, verify that we did a swap in the last one
      		if (swapped == false) {
      			// If we did not do a swap in the last pass, go ahead and quit because we're done
      			break;
      		}
       } // End Outer Loop
	}		

}
