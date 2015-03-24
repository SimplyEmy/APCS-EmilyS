package Car_Class;


public class CarMainProgram {

	public static void main(String[] args) {
		Car batmobile = new Car("Lincoln", "Futura", 1966);
		String[] batmobileFeatures = {"bullet-proof", "low MPG"};
		batmobile.SpecialFeatures = batmobileFeatures;
		
		Car timeMachine = new Car("DeLorean", "DMC 12", 1981);
		String[] timeMachineFeatures = {"green-powered", "time travel", "spaceship-like doors"};
		timeMachine.SpecialFeatures = timeMachineFeatures;
		
		int carComparison = batmobile.CompareAgeTo(timeMachine);
		
		if(carComparison == -1){
			System.out.println("The " + batmobile.GetMakeAndModel() + " is older than the " + timeMachine.GetMakeAndModel());
		}
		else if (carComparison == 1){
			System.out.println("The " + timeMachine.GetMakeAndModel() + " is older than the " + batmobile.GetMakeAndModel());
		}
		else{
			System.out.println("The " + batmobile.GetMakeAndModel() + " and the " + timeMachine.GetMakeAndModel() + " were made the same year");
		}
		
		if(!batmobile.IsNewCar()){
			System.out.println("Batman needs a new car!");
		}

	}

}
