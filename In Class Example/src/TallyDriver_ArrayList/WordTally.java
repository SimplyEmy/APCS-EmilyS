package TallyDriver_ArrayList;

public class WordTally {
	public String word;
	public int counter;

	// constructor: initialize word, set counter to 1
	public WordTally(String s) {
		word = s;
		counter = 1;
	}

	// increment counter
	public void counterInc() {
		counter++;
	}

	// print function
	public String toString() {
		return word + " appears " + counter + " times.";
	}
}
