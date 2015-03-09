public class Chapt2ExercisesSet2 {
	//rows and columns in environment
	private static final int ENV_ROWS = 20; 
	private static final int ENV_COLS = 20;
	
	public static void main(String[] args){
		
		//Construct an empty environment and several fish in the context
		//of that environment
		BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
		
		//Info from analysis question 3
		Location loc1 = new Location(7, 3);
		Location loc2 = new Location(7, 6);
		Location loc3 = new Location(4, 8);
		Fish f1 = new Fish(env, loc1);
		Fish f2 = new Fish(env, loc2);
	
		//Exercise 2 Question 3
		//env.add(new Fish(env, new Location(8,8)));
		
		//Exercise 2 Question 2
		//Adding more fish 
		Fish f3 = new Fish(env, new Location(0, 0));
		Fish f4 = new Fish(env, new Location(2, 7));
		Fish f5 = new Fish(env, new Location(7, 7));
		
		//printing Number of objects
		System.out.println("Number of objects: " + env.numObjects());
		
		//printing the objects
        System.out.println("Objects in the environment are: ");
        Locatable[] fishList = env.allObjects();
        for(int idx = 0; idx < fishList.length; idx++){
        	System.out.println((Fish) fishList[idx]);
        }
        
		// Removing some fish and printing again
        env.remove(f2);
        env.remove(f4);
        
        System.out.println("After removing fishes f2 and f4, the objects in the environment in the environment are: ");
        
        fishList = env.allObjects();
        for(int x = 0; x < fishList.length; x++){
        	System.out.println((Fish) fishList[x]);
        }
        
        //Checking if locations are empty
        System.out.println("Is the location of f1 empty? " + env.isEmpty(f1.location()));
        
        System.out.println("Is the location of f2 empty? " + env.isEmpty(f2.location()));
		
		
		
		//Checking Answers for question 1
		
		//Question 1
		System.out.println("Number of objects: " + env.numObjects());
	
		//Question 2
        System.out.println("Objects in the environment are: ");
        Locatable[] FishList = env.allObjects();
        for(int idx = 0; idx < FishList.length; idx++){
        	System.out.println((Fish) FishList[idx]);
        }
        
        //Question 3
        System.out.println("Is loc1 empty? " + env.isEmpty(loc1));
        
        //Question 4
        System.out.println("Is loc3 empty? " + env.isEmpty(loc3));
        
        //Question 5
        System.out.println("The object at loc1 is " + (Fish)env.objectAt(loc2));
        
        //Question 6
        System.out.println("The object at loc3 is " + (Fish)env.objectAt(loc3));
        
        
    }
}
