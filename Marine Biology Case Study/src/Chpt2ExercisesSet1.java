
public class Chpt2ExercisesSet1 {
	// rows and columns in environment.
    private static final int ENV_ROWS = 20;      // rows in environment
    private static final int ENV_COLS = 20;      // columns in environment

    // timesteps to run the simulation.
    //private static final int NUM_STEPS = 15;     // number of timesteps

    // time delay for each step
    //private static final int DELAY = 1000;        // delay in milliseconds

    
    public static void main(String[] args)
    {
        // Construct an empty environment and several fish in the context
        // of that environment.
        BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
       
        
        Location loc1 = new Location(7, 3);
        Location loc2 = new Location(7, 4);
        Direction dir1 = env.getDirection(loc1, loc2);
        Direction dir2 = dir1.toRight(90);
        Direction dir3 = dir2.reverse();
        Location loc3 = env.getNeighbor(loc1,  dir3);
        Location loc4 = env.getNeighbor(new Location(5, 2), dir1);
        
        System.out.println("dir1 = " + dir1);
        System.out.println("dir2 = " + dir2);
        System.out.println("dir3 = " + dir3);
        System.out.println("loc1 Neighbors = " + env.neighborsOf(loc1));
        System.out.println("loc3 = " + loc3);
        System.out.println("loc 4 = " + loc4);
        
        System.out.println();
        System.out.println("Finding Degrees: ");
        System.out.println("North = " + Direction.NORTH.inDegrees());
        System.out.println("South = " + Direction.SOUTH.inDegrees());
        System.out.println("East = " + Direction.EAST.inDegrees());
        System.out.println("West = " + Direction.WEST.inDegrees());
        
        System.out.println("dir3 in degrees = " + dir3.inDegrees());
    }
}
