import java.util.ArrayList;
public class Chapt2ExercisesSet3 {
	//rows and columns in environment
	private static final int ENV_ROWS = 20; 
	private static final int ENV_COLS = 20;

	public static void main(String[] args) {
		//Construct an empty environment and several fish in the context
		//of that environment
		BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
		
		//information given in problem
		Location loc1 = new Location(0, 0);
		Location loc2 = new Location(0, 1);
		Location loc3 = new Location(1, 1);
		
		//Exercise Set 3 Question 1
		ArrayList neighbors1 = env.neighborsOf(loc1);
		ArrayList neighbors2 = env.neighborsOf(loc2);
		ArrayList neighbors3 = env.neighborsOf(loc3);
		
		//Printing locations and neighbors
		System.out.println("Location " + loc1 + " has " + neighbors1.size() + " neighbors");
		System.out.println("Location " + loc2 + " has " + neighbors2.size() + " neighbors");
		System.out.println("Location " + loc3 + " has " + neighbors3.size() + " neighbors");
		
		//Answer Exercise Set 3 Question 2
		System.out.print("The neighbors of location " + loc1 + " are: ");
		for (int idx = 0; idx < neighbors1.size(); idx++){
			System.out.print(neighbors1.get(idx) + " ");
		}
		System.out.println();
		
		System.out.print("The neighbors of location " + loc2 + " are: ");
		for (int idx = 0; idx < neighbors2.size(); idx++){
			System.out.print(neighbors2.get(idx) + " ");
		}
		System.out.println();
		
		System.out.print("The neighbors of location " + loc3 + " are: ");
		for (int idx = 0; idx < neighbors2.size(); idx++){
			System.out.print(neighbors2.get(idx) + " ");
		}
		System.out.println();

	}

}
