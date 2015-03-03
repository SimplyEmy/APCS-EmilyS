
public class Chapt2ExercisesSet2 {
	// rows and columns in environment.
    private static final int ENV_ROWS = 20;      // rows in environment
    private static final int ENV_COLS = 20;      // columns in environment

    
    public static void main(String[] args)
    {
        // Construct an empty environment and several fish in the context
        // of that environment.
        BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
        
        //Info from analysis question 3
        Location loc1 = new Location(7, 3);
        Location loc2 = new Location(7, 6);
        Location loc3 = new Location(4, 8);
        Fish f1 = new Fish(env, loc1);
        Fish f2 = new Fish(env, loc2);
        
        
        //Checking Answers
        
        //Question 1
        System.out.println("Number of objects: " + env.numObjects());
        
        //Question 2
        System.out.println("Objects in the environment are: ");
        Locatable[] fishList = env.allObjects();
        for(int idx = 0; idx < fishList.length; idx++){
        	System.out.println((Fish) fishList[idx]);
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
