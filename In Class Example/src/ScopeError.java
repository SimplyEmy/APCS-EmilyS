// This program has several scope, syntax and logic errors.  
// Fix the errors so that the program 
// will compile and run correctly.
public class ScopeError {
	//Declare the constant PI:
	private static double PI = 3.14159265;
	//Set the radius of the circle to 4:
	static double Radius = 4;
	//Set the side to 6 cm
	static double Side = 6;
	
	public static void main(String[] args) {
		
		//Call the Print Circle Method
		PrintCircleStats();
	
	
		//Call the Print Square Area Method
		PrintSquareArea();
	
	}
	
	private static void PrintCircleStats(){
		double Area = Math.pow(Radius,  2) * PI;
	
		System.out.println("The area of the circle is: "+ Area); 
	}
	
	public static void PrintSquareArea(){
		double Area = Math.pow(Side, 2);
		System.out.println("The area of the square is: "+ Area); 
	}
	
}