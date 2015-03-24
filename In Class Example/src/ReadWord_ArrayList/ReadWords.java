package ReadWord_ArrayList;

// Seattle Prep CS class
// 3/3/2014
//
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWords {

	public static void main(String[] args) {
		// ArrayList to store the words
		ArrayList<String> a = new ArrayList<String>();

		// set up input scanner
		Scanner input = new Scanner(System.in);

		// repeat until break
		while (true) {
			// read line, break out of loop if "quit" is typed
			System.out.print("Word? ");
			String s = input.nextLine();
			
			//a.add(s);
			
			if (s.equals("quit")) {
				break;
			//checking if duplicate
			}else if(!a.contains(s)){
				if(a.size() > 0){
					for(int idx = 0; idx < a.size(); idx++){	
						if(s.compareTo(a.get(idx)) > 0){
							a.add(idx,s);
						}else {
						 a.add(s);
						}
					}
				}
			} else {	
				a.add(s);
			}
		}
		
	//printing the array in a line
	for(int x = 0; x < a.size(); x++){
		System.out.println(a.get(x));
	}
		
		

		// close input
		input.close();
	}
}
