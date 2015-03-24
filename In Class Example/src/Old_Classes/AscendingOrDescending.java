package Old_Classes;


import java.util.*;

public class AscendingOrDescending {

	public static void main(String[] args) {
		String series;
		String name;
		String numberString;
		int numberInteger;
		int space;
		int previous;
		boolean ascending;
		          
		Scanner scan = new Scanner(System.in);
		System.out.print("Series? ");
		series = scan.nextLine();
		 
		space = series.indexOf(' ');
		name = series.substring(0, space);
		series = series.substring(space + 1);
		          
		space = series.indexOf(' ');
		
		numberString = series.substring(0, space);
		numberInteger = Integer.parseInt(numberString);
		
		series = series.substring(space + 1);
		
		ascending = true;
		           
		previous = numberInteger;
		 
		space = series.indexOf(' ');
		
		while (space != -1) {
		                 
		  numberString = series.substring(0, space);
		  numberInteger = Integer.parseInt(numberString);
		  series = series.substring(space + 1);
		                
		  if (numberInteger < previous) {
		      ascending = false;
		  }
		                 
		    previous = numberInteger;
		                
		    space = series.indexOf(' ');
		  }
		          
		  numberInteger = Integer.parseInt(series);
		  if (numberInteger < previous) {
		       ascending = false;
		  }
		           
		  while(!series.equals("quit")){
			  if (ascending) {
				  System.out.println("Series " + name + " is ascending");
			  } else {
				  System.out.println("Series " + name + " is not ascending");
			  }
			  System.out.println();
			  System.out.print("Series? ");
			  series = scan.nextLine();
		  }
	 }
}
		 
