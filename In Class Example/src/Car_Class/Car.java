package Car_Class;

public class Car {
	public String Make;
	public String Model;
	public int Year;
	public String[] SpecialFeatures;
	
	public Car(String make, String model, int year){
		Make = make;
		Model = model;
		Year = year;
	}
	
	public String GetMakeAndModel(){
		return Make + " " + Model;
	}
	
	public int CompareAgeTo(Car otherCar){
		if(Year < otherCar.Year){
			return -1;
		}
		else if (Year > otherCar.Year){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public boolean IsNewCar(){
		return Year == YearOfNewCar;
	}
	
	public static int YearOfFirstCar = 1678;
	public static int YearOfNewCar = 2015;
}
