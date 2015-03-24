package Players_Class;

public class MainProgram {
	// client for Person and Date classes
		public static void main(String[] args) {
			Player[] roster = { new Player("Rusell Wilson", "11/29/1988"),
	new Player("Marshawn Lynch", "4/22/1986"),
				new Player("Doug Baldwin", "9/21/1988"),
	new Player("Michael Bennett", "11/13/1985"),
				new Player("Clint Gresham", "8/24/1986"),
	new Player("Jermaine Kearse", "2/6/1990"),
				new Player("Richard Sherman", "3/30/1988"),
	new Player("Earl Thomas", "5/7/1989"),
				new Player("Bryan Walters", "11/4/1987"),
	new Player("Tharold Simon", "3/6/1991"),
				new Player("Bobby Wagner", "6/27/1990")};

			// print team, and various subsets
			printTeam(roster);
			printPlayersBornBefore1987(roster);
			printYougestPlayer(roster);
			printSecondYougestPlayer(roster);
		}

		// print all players in the set
		static void printTeam(Player[] r) {
			System.out.println("All players:");
			for (int i = 0; i < r.length; i++) {
				System.out.println(r[i]);
			}
		}

		// print players born before 1987
		static void printPlayersBornBefore1987(Player[] r) {
			System.out.println();
			System.out.println("**Write method printPlayersBornBefore1987**");
			System.out.println("Born before 1987: ");
			for(int i = 0; i < r.length; i++){
				if(r[i].getBirthday().getYear() > 1987){
					System.out.println(r[i].getName());
				}
			}
		}

		// print youngest player
		static void printYougestPlayer(Player[] r) {
			System.out.println();
			System.out.println("**Write method printYougestPlayer**");
			
			Player youngest = r[0];
			for (int i = 0; i < r.length; i++){
				if(youngest.getBirthday().compare(r[i].getBirthday()) == -1){
					youngest = r[i];
				}
			}
			System.out.println("Youngest Player: " + youngest);
		}

		// print second youngest player
		static void printSecondYougestPlayer(Player[] r) {
			System.out.println();
			System.out.println("**Write method printSecondYougestPlayer**");
			
			Player secondYoungest = r[0];
			for (int i = 0; i < r.length; i++){
				if(secondYoungest.getBirthday().compare(r[i].getBirthday()) == -1){
					secondYoungest = r[i - 1];
				}
			}
			System.out.println("Second Youngest Player: " + secondYoungest);
		}
		
	}
	 



