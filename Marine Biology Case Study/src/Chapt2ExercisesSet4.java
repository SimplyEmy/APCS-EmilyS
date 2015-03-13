import java.awt.Color;


public class Chapt2ExercisesSet4 {
	//rows and columns in environment
	private static final int ENV_ROWS = 20; 		
	private static final int ENV_COLS = 20;
	private static final int NUM_STEPS = 20;
	
	public static void main(String[] args){
		
		//Construct an empty environment and several fish in the context
		//of that environment
		BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
		
		//Chapter 2, Exercise Set 4, Question 2
		//Initializing direction and color
		Direction dir = new Direction("east");
		Color col = new Color(200, 50, 50);
	
		Fish f1 = new Fish(env, new Location(2, 2), dir, col);
		Fish f2 = new Fish(env, new Location(2, 3), new Direction ("west"), new Color(100, 150, 50));
		Fish f3 = new Fish(env, new Location(5, 8), new Direction("south"), new Color(50, 50, 100));


		for(int x = 0; x < NUM_STEPS; x++){
			
			if(x % 2 == 0){  //even numbered steps
				f1.changeColor(Color.red);
			}else{
				f1.changeColor(Color.yellow);
			}
			
		}
	}

}