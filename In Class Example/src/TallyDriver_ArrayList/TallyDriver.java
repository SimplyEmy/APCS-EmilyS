package TallyDriver_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class TallyDriver {

	public static void main(String[] args) {
		// ArrayList to store the words
		ArrayList<WordTally> a = new ArrayList<WordTally>();

		// set up input scanner
		Scanner input = new Scanner(System.in);

		// repeat until break
		while (true) {
			// read line, break out of loop if "quit" is typed
			System.out.print("Word? ");
			String s = input.nextLine();
			if (s.equals("quit")) {
				break;
			}

			// keep tally
			insertAndTally(a, s);
		}

		// print tally
		for (int idx = 0; idx < a.size(); idx++) {
			System.out.println(a.get(idx));
		}

		// close input
		input.close();
	}

	// keep track of words
	static void insertAndTally(ArrayList<WordTally> a, String w) {
		boolean test = true;
		for(int x = 0; x < a.size(); x++){
			if (w.equals(a.get(x).word)){
				test = false;
			}
		}
		
		if(test){
			WordTally s = new WordTally(w);
			a.add(s);
			//a.add(new WordTally(w));
		} else {
			for (int x = 0; x < a.size(); x++){
				if (w.equals(a.get(x).word)){
					a.get(x).counterInc();
				}
			}
		}
	}
}
